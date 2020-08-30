package com.example.demo.family;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/family")
public class FamilyController {
    private static final List<FamilyMember> MEMBER_LIST = Arrays.asList(
            new FamilyMember((long) 1, "Brian", "Smith"),
            new FamilyMember((long) 2, "Susan", "Smith"),
            new FamilyMember((long) 3, "Shawn", "Smith"),
            new FamilyMember((long) 4, "Alyssa", "Smith"),
            new FamilyMember((long) 5, "Scott", "Smith")
    );

    @GetMapping("{memberId}")
    public FamilyMember getFamilyMember(@PathVariable Long memberId) {
        return MEMBER_LIST.stream()
                .filter(familyMember -> memberId.equals(familyMember.getMemberId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(
                        "Family Member " + memberId + " does not exist"
                ));
    }
}
