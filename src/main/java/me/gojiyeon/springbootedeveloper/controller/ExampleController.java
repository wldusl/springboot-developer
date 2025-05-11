package me.gojiyeon.springbootedeveloper.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;

@Controller //컨트롤러라는 것을 명시적으로 표시
public class ExampleController {

    @GetMapping("/thymleaf/example")
    public String thymeleafExample(Model model) { //뷰로 데이터를 넘겨주는 모델
        Person examplePerson = new Person();
        examplePerson.setId(1L);
        examplePerson.setName("지연");
        examplePerson.setAge(28);
        examplePerson.setHobbies(List.of("운동", "낮잠"));

        model.addAttribute("person", examplePerson); //Person객체 작성
        model.addAttribute("today", LocalDate.now());

        return "example";  //example.html 이라는 뷰 조회
    }

    @Setter
    @Getter
    class Person {
        private Long id;
        private String name;
        private int age;
        private List<String> hobbies;
    }
}
