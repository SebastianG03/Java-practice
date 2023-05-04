package ejercicio_cajas;

import java.util.Objects;

public class Cajas {

    private Long serialKey;
    private String companyName;

    public Cajas(Long serialKey, String companyName) {
        this.serialKey = serialKey;
        this.companyName = companyName;
    }

    public Long getSerialKey() {
        return serialKey;
    }

    public String getCompanyName() {
        return companyName;
    }

    @Override
    public String toString() {
        return "Caja " + serialKey +
                "\nCompañía: " + companyName + "\n";
    }

    public boolean equals(Long serialKey) {
        if (this.serialKey == serialKey) return true;
        if (serialKey == null || this.serialKey.getClass() != serialKey.getClass()) return false;
        return Objects.equals(serialKey, this.serialKey);
    }
}
