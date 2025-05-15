package com.rikkei.ss08.controller;

import com.rikkei.ss08.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GameController {
    private List<Seeds> seedsList = new ArrayList<>();
    private List<Player> playersList = new ArrayList<>();
    private Player currentPlayer;

    @RequestMapping("/home")
    public String home(Model model) {
        if (currentPlayer == null) {
            return "redirect:/registerUser";
        }
        model.addAttribute("seedsList", seedsList);
        return "Bai8910/home";
    }

    @RequestMapping("/registerUser")
    public String registerForm() {
        return "Bai8910/register";
    }

    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public String registerUser(@RequestParam String username, @RequestParam String password, @RequestParam String email) {
        Player newPlayer = new Player();
        newPlayer.setUsername(username);
        newPlayer.setPassword(password);
        newPlayer.setEmail(email);

        List<FarmPlot> farmList = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            farmList.add(new FarmPlot(i, null));
        }
        newPlayer.setFarm(farmList);

        newPlayer.setWarehouse(new ArrayList<>());

        playersList.add(newPlayer);
        return "redirect:/login";
    }

    @RequestMapping("/login")
    public String loginForm() {
        return "Bai8910/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginUser(@RequestParam String username, @RequestParam String password) {
        for (Player player : playersList) {
            if (player.getUsername().equals(username) && player.getPassword().equals(password)) {
                currentPlayer = player;
                return "redirect:/home";
            }
        }
        return "Bai8910/login";
    }

    @RequestMapping("/shop")
    public String shop(Model model) {
        if (currentPlayer == null) {
            return "redirect:/registerUser";
        }
        if (seedsList.isEmpty()) {
            seedsList.add(new Seeds(1, "Wheat", 50, "https://vaas.vn/kienthuc/Caylua/img/10_caylua01.jpg"));
            seedsList.add(new Seeds(2, "Corn", 100, "https://phanbonhuunghi.vn/wp-content/uploads/2021/01/Cach-trong-va-cham-soc-cay-ngo-nang-suat.jpg"));
            seedsList.add(new Seeds(3, "Rice", 150, "https://www.thespruce.com/thmb/WP3_qHmIzpoYDsAqns0fPEdV6js=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/wheat-growing-guide-5272256-hero-8f4d4582be684c90944ec950cae8edd2.jpg"));
        }
        model.addAttribute("seedsList", seedsList);
        return "Bai8910/shop";
    }

    @RequestMapping(value = "/buySeed", method = RequestMethod.POST)
    public String buySeed(@RequestParam int seedId) {
        if (currentPlayer == null) return "redirect:/registerUser";

        Seeds seedToBuy = null;
        for (Seeds seed : seedsList) {
            if (seed.getId() == seedId) {
                seedToBuy = seed;
                break;
            }
        }

        if (seedToBuy != null && currentPlayer.getBalance() >= seedToBuy.getPrice()) {
            currentPlayer.setBalance(currentPlayer.getBalance() - seedToBuy.getPrice());
            boolean found = false;
            for (WarehouseSeeds ws : currentPlayer.getWarehouse()) {
                if (ws.getSeeds().getId() == seedToBuy.getId()) {
                    ws.setQuantity(ws.getQuantity() + 1);
                    found = true;
                    break;
                }
            }

            if (!found) {
                WarehouseSeeds newWS = new WarehouseSeeds(seedToBuy.getId(), 1, seedToBuy);
                currentPlayer.getWarehouse().add(newWS);
            }
        }

        return "redirect:/shop";
    }

    @RequestMapping("/warehouse")
    public String viewWarehouse(Model model) {
        if (currentPlayer == null) return "redirect:/registerUser";
        model.addAttribute("warehouse", currentPlayer.getWarehouse());
        return "Bai8910/warehouse";
    }

    @RequestMapping("/farm")
    public String viewFarm(Model model) {
        if (currentPlayer == null) return "redirect:/registerUser";
        model.addAttribute("farm", currentPlayer.getFarm());
        model.addAttribute("warehouse", currentPlayer.getWarehouse());
        return "Bai8910/farm";
    }

    @RequestMapping(value = "/plant", method = RequestMethod.POST)
    public String plantSeed(@RequestParam int plotPosition, @RequestParam int seedId) {
        if (currentPlayer == null) return "redirect:/registerUser";
        for (WarehouseSeeds ws : currentPlayer.getWarehouse()) {
            if (ws.getSeeds().getId() == seedId && ws.getQuantity() > 0) {
                for (FarmPlot plot : currentPlayer.getFarm()) {
                    if (plot.getPosition() == plotPosition && plot.getSeed() == null) {
                        plot.setSeed(ws.getSeeds());
                        ws.setQuantity(ws.getQuantity() - 1);
                        break;
                    }
                }
                break;
            }
        }

        return "redirect:/farm";
    }
}
