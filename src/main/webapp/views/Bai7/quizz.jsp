<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HOANGNAM
  Date: 5/14/2025
  Time: 3:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đuổi Hình Bắt Chữ</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background: linear-gradient(135deg, #f5f7fa 0%, #c3cfe2 100%);
            min-height: 100vh;
            margin: 0;
            padding: 20px;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        .game-container {
            background: white;
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0 10px 20px rgba(0,0,0,0.1);
            max-width: 600px;
            width: 90%;
            text-align: center;
        }

        h1 {
            color: #2c3e50;
            margin-bottom: 25px;
            font-size: 2.2em;
            text-transform: uppercase;
            letter-spacing: 2px;
        }

        .question-image {
            border: 5px solid #3498db;
            border-radius: 10px;
            margin: 20px 0;
            box-shadow: 0 5px 15px rgba(0,0,0,0.2);
            max-width: 100%;
            height: auto;
        }

        .answer-form {
            margin: 25px 0;
        }

        .answer-input {
            padding: 12px 20px;
            font-size: 18px;
            border: 2px solid #3498db;
            border-radius: 25px;
            width: 70%;
            margin-right: 10px;
            outline: none;
        }

        .guess-button {
            padding: 12px 30px;
            background: #3498db;
            color: white;
            border: none;
            border-radius: 25px;
            cursor: pointer;
            font-size: 16px;
            transition: all 0.3s ease;
        }

        .guess-button:hover {
            background: #2980b9;
            transform: translateY(-2px);
            box-shadow: 0 5px 15px rgba(52,152,219,0.4);
        }

        .message {
            font-size: 20px;
            margin: 20px 0;
            padding: 15px;
            border-radius: 8px;
        }

        .success {
            background: #2ecc71;
            color: white;
        }

        .error {
            background: #e74c3c;
            color: white;
        }

        .remaining-guesses {
            font-size: 18px;
            color: #34495e;
            margin: 15px 0;
        }

        .restart-button {
            padding: 12px 30px;
            background: #e67e22;
            color: white;
            border: none;
            border-radius: 25px;
            cursor: pointer;
            font-size: 16px;
            margin-top: 20px;
            transition: all 0.3s ease;
        }

        .restart-button:hover {
            background: #d35400;
            transform: scale(1.05);
        }
    </style>
</head>
<body>
<div class="game-container">
    <h1>🎮 Đuổi Hình Bắt Chữ 🎯</h1>

    <img src="${question.imageUrl}" alt="Câu hỏi" class="question-image"/>

    <form action="${pageContext.request.contextPath}/guess" method="post" class="answer-form">
        <div>
            <input
                    type="text"
                    id="userAnswer"
                    name="userAnswer"
                    class="answer-input"
                    placeholder="Nhập đáp án của bạn..."
                    autocomplete="off"
            >
            <button type="submit" class="guess-button">ĐOÁN</button>
        </div>
    </form>

    <c:if test="${not empty message}">
        <div class="message ${correct ? 'success' : 'error'}">
                ${message}
        </div>
    </c:if>

    <c:if test="${remainingGuesses > 0}">
        <div class="remaining-guesses">
            ⏳ Bạn còn ${remainingGuesses} lượt đoán
        </div>
    </c:if>

    <c:if test="${remainingGuesses == 0}">
        <form action="${pageContext.request.contextPath}/restart" method="get">
            <button type="submit" class="restart-button">🔄 Chơi Lại</button>
        </form>
    </c:if>
</div>
</body>
</html>