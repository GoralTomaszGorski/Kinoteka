package com.example.kinoteka.web.admin;

import com.example.kinoteka.domain.type.TypeService;
import com.example.kinoteka.domain.type.dto.TypeDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TypeManagementController {
    private final TypeService typeService;

    public TypeManagementController(TypeService typeService) {
        this.typeService = typeService;
    }

    @GetMapping("/admin/dodaj-gatunek")
    public String addTypeForm(Model model) {
        TypeDto type = new TypeDto();
        model.addAttribute("type", type);
        return "admin/type-form";
    }

    @PostMapping("/admin/dodaj-gatunek")
    public String addType(TypeDto typeDto, RedirectAttributes redirectAttributes) {
        typeService.addType(typeDto);
        redirectAttributes.addFlashAttribute(
                AdminController.NOTIFICATION_ATTRIBUTE,
                "Gatunek %s został dodany i zapisany".formatted(typeDto.getName()));
        return "redirect:/admin";

    }

}
