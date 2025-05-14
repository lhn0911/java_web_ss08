package com.rikkei.ss08.controller;

import com.rikkei.ss08.model.Question;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class QuizController {
    private final List<Question> questions = new ArrayList<>();

    public QuizController() {
        questions.add(new Question(1, "https://cdn2.tuoitre.vn/471584752817336320/2023/4/20/phu-yen-1-16819671427591853833321.jpg", "Phú Yên"));
        questions.add(new Question(2, "https://cdn2.tuoitre.vn/471584752817336320/2023/4/20/lang-son-1-1681967142747385488588.jpg", "Lạng Sơn"));
        questions.add(new Question(3, "https://cdn2.tuoitre.vn/471584752817336320/2023/4/20/nam-dinh-1-16819671427531097019684.jpg", "Nam Định"));
        questions.add(new Question(4, "https://cdn2.tuoitre.vn/471584752817336320/2023/4/20/son-la-1-16819586277071003672189.jpg", "Sơn La"));
        questions.add(new Question(5, "https://cdn2.tuoitre.vn/471584752817336320/2023/4/20/ha-nam-1-16819586277031164925524.jpg", "Hà Nam"));
        questions.add(new Question(6, "https://cdn2.tuoitre.vn/471584752817336320/2023/4/20/cao-bang-1-1681958627697801469287.jpg", "Cao Bằng"));
        questions.add(new Question(7, "https://cdn2.tuoitre.vn/471584752817336320/2023/4/18/ben-tre-2-16818085158261714000309.jpg", "Bến Tre"));
        questions.add(new Question(8, "https://cdn2.tuoitre.vn/471584752817336320/2023/4/18/dong-thap-2-16818085158402030875642.jpg", "Đồng Tháp"));
        questions.add(new Question(9, "https://cdn2.tuoitre.vn/471584752817336320/2023/4/18/ca-mau-2-16818085158351828675783.jpg", "Cà Mau"));
        questions.add(new Question(10, "https://cdn2.tuoitre.vn/471584752817336320/2023/4/18/hai-phong-2-1681807825377471411391.jpg", "Hải Phòng"));


    }

    @GetMapping("/quiz")
    public String showQuiz(Model model, HttpSession session) {
        Integer currentIndex = (Integer) session.getAttribute("currentIndex");
        Integer remainingGuesses = (Integer) session.getAttribute("remainingGuesses");
        Integer score = (Integer) session.getAttribute("score");

        if (currentIndex == null) {
            currentIndex = 0;
            remainingGuesses = 3;
            score = 0;
        }

        if (currentIndex >= questions.size() || remainingGuesses <= 0) {
            session.setAttribute("score", score);
            return "redirect:/endgame";
        }

        Question currentQuestion = questions.get(currentIndex);
        session.setAttribute("currentIndex", currentIndex);
        session.setAttribute("remainingGuesses", remainingGuesses);
        session.setAttribute("score", score);
        session.setAttribute("currentQuestion", currentQuestion);

        model.addAttribute("question", currentQuestion);
        model.addAttribute("remainingGuesses", remainingGuesses);
        model.addAttribute("message", "");

        return "Bai7/quizz";
    }

    @PostMapping("/guess")
    public String submitGuess(String userAnswer, Model model, HttpSession session) {
        Question currentQuestion = (Question) session.getAttribute("currentQuestion");
        Integer currentIndex = (Integer) session.getAttribute("currentIndex");
        Integer remainingGuesses = (Integer) session.getAttribute("remainingGuesses");
        Integer score = (Integer) session.getAttribute("score");

        if (currentQuestion == null || currentIndex == null || remainingGuesses == null || score == null) {
            return "redirect:/quiz";
        }

        if (remainingGuesses <= 0 || currentIndex >= questions.size()) {
            return "redirect:/endgame";
        }

        if (userAnswer != null && userAnswer.trim().toLowerCase().equals(currentQuestion.getAnswer().trim().toLowerCase())) {
            score++;
            currentIndex++;
            session.setAttribute("score", score);
            session.setAttribute("currentIndex", currentIndex);
            model.addAttribute("message", "Chính xác!");
        } else {
            remainingGuesses--;
            session.setAttribute("remainingGuesses", remainingGuesses);
            model.addAttribute("message", "Sai rồi! Còn " + remainingGuesses + " lượt.");
        }


        return "redirect:/quiz";
    }

    @GetMapping("/restart")
    public String restartQuiz(HttpSession session) {
        session.invalidate();
        return "redirect:/quiz";
    }

    @GetMapping("/endgame")
    public String showEndGame(HttpSession session, Model model) {
        Integer score = (Integer) session.getAttribute("score");
        model.addAttribute("score", score != null ? score : 0);
        return "Bai7/endgame";
    }
}
