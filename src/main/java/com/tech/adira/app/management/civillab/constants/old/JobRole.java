package com.tech.adira.app.management.civillab.constants.old;

public enum JobRole {
    ADMIN("Admin"),
    SITE_ADMIN("Site Admin"),
    SITE_MANAGER("Site Manager"),
    SUPERVISOR_1("Supervisor"),
    SUPERVISOR_2("Senior Supervisor"),
    DRIVER("Driver");

    private final String role;

    JobRole(String role){
        this.role = role;
    }

    public String role(){
        return this.role;
    }
}
