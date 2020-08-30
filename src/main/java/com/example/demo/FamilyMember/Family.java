package com.example.demo.FamilyMember;

public class Family {
    private Long familyId;
    private String name;

    public Family(Long familyId, String name) {
        this.familyId = familyId;
        this.name = name;
    }

    public Long getFamilyId() {
        return familyId;
    }

    public void setFamilyId(Long familyId) {
        this.familyId = familyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
