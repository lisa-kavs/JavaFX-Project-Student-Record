package com.example.oopro_assignment;

import java.util.ArrayList;

public class ModuleList {
    private ArrayList<Module> module;

    public ModuleList(){
        module = new ArrayList<Module>();
    }

    public ArrayList<Module> getModuleList(){
        return module;
    }

    public void addModule(Module m){
        module.add(m);

    }



    public Module getModule(int i){
        if((i>-1)&&(i < module.size())) {
            return module.get(i);
        }

        return null;
    }

    public int getModuleSize(){
        return module.size();
    }
}
