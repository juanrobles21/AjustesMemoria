package controller;

import model.MemorySize;

import java.util.ArrayList;
import java.util.List;

public class MemorySizeController {
    private List<MemorySize> memorySizes;

    public MemorySizeController() {
        memorySizes = new ArrayList<MemorySize>();
    }

    public List<MemorySize> getMemorySizes() {
        return memorySizes;
    }

    public void setMemorySizes(List<MemorySize> memorySizes) {
        this.memorySizes = memorySizes;
    }

    public void insertDates() {
        memorySizes.add(new MemorySize(1000));
        memorySizes.add(new MemorySize(400));
        memorySizes.add(new MemorySize(1800));
        memorySizes.add(new MemorySize(700));
        memorySizes.add(new MemorySize(900));
        memorySizes.add(new MemorySize(1200));
        memorySizes.add(new MemorySize(1500));
    }

    public String values() {
        String values = "";
        for (int i = 0; i < memorySizes.size(); i++) {
            values = memorySizes.toString();
        }
        return values;

    }

    public String primerAjuste(String jobSize) {
        boolean bandera = false;
        int jobSizeInt = 0;
        int memory = 0;
        String job = "";
        String values = "";
        try {
            jobSizeInt = Integer.parseInt(jobSize);

        } catch (NumberFormatException nfe) {
            return "El valor no es correcto";

        }
        for (int i = 0; i < memorySizes.size(); i++) {
            if (jobSizeInt <= memorySizes.get(i).getMemorySize()) {
                job = String.valueOf(memorySizes.get(i).getMemorySize());
                memory = memorySizes.get(i).getMemorySize() - jobSizeInt;
                memorySizes.get(i).setMemorySize(memory);
                values = memorySizes.toString();
                bandera = true;
                break;
            }
        }
        if (bandera == false) {
            return "Espacio de memoria no se encuentra disponible";
        }
        return "El tamaño del archivo es: " + jobSize + " Espacio de memoria utiliazdo: " + job + " kb\n" + values;
    }

    public String mejorAjuste(String jobSize) {
        boolean bandera = false;
        int jobSizeInt = 0;
        int position = 0;
        int value = 0;
        int memory = 0;
        String job = "";
        String values = "";
        try {
            jobSizeInt = Integer.parseInt(jobSize);

        } catch (NumberFormatException nfe) {
            return "El valor no es correcto";

        }
        for (int i = 0; i < memorySizes.size(); i++) {
            if (jobSizeInt <= memorySizes.get(i).getMemorySize()) {
                memory = memorySizes.get(i).getMemorySize();
                if (i == 0) {
                    value = memory;
                    position = i;
                } else if (memory < value) {
                    value = memory;
                    position = i;
                }
                memory = memorySizes.get(position).getMemorySize() - jobSizeInt;
                job = String.valueOf(memorySizes.get(position).getMemorySize());
                bandera = true;
            }
        }
        if (bandera == false) {
            return "Espacio de memoria no se encuentra disponible";
        }
        for (int i = 0; i < memorySizes.size(); i++) {
            memorySizes.get(position).setMemorySize(memory);
            values = memorySizes.toString();
        }
        return "El tamaño del archivo es: " + jobSize + " Espacio de memoria utiliazdo: " + job + " kb\n" + values;
    }

    public String peorAjuste(String jobSize) {
        boolean bandera = false;
        int jobSizeInt = 0;
        int position = 0;
        int max = 0;
        int memory = 0;
        String job = "";
        String values = "";
        try {
            jobSizeInt = Integer.parseInt(jobSize);

        } catch (NumberFormatException nfe) {
            return "El valor no es correcto";

        }
        for (int i = 0; i < memorySizes.size(); i++) {
            if (jobSizeInt <= memorySizes.get(i).getMemorySize()) {
                memory = memorySizes.get(i).getMemorySize();
                if (i == 0) {
                    max = memory;
                    position = i;
                } else if (memory > max) {
                    max = memory;
                    position = i;
                }
                memory = memorySizes.get(position).getMemorySize() - jobSizeInt;
                job = String.valueOf(memorySizes.get(position).getMemorySize());
                bandera = true;
            }
        }
        if (bandera == false) {
            return "Espacio de memoria no se encuentra disponible";
        }
        for (int i = 0; i < memorySizes.size(); i++) {
            memorySizes.get(position).setMemorySize(memory);
            values = memorySizes.toString();
        }
        return "El tamaño del archivo es:" + jobSize + " Espacio de memoria utiliazdo: " + job + " kb\n" + values;
    }
}
