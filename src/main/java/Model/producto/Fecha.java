package Model.producto;

import java.time.LocalDate;

public class Fecha {
    private final int DIA;
    private final int MES;
    private final int ANIO;

    public Fecha(int dia, int mes, int anio){
        DIA = dia;
        MES = mes;
        ANIO = anio;
    }

    public Fecha(){
        LocalDate fecha = LocalDate.now();
        DIA = fecha.getDayOfMonth();
        MES = fecha.getMonthValue();
        ANIO = fecha.getYear();
    }

    public int getDia(){
        return DIA;
    }

    public int getMes(){
        return MES;
    }

    public int getAnio(){
        return ANIO;
    }

    public boolean esMayor(Fecha fecha){
        if(ANIO > fecha.getAnio()){
            return true;
        } else if(ANIO == fecha.getAnio()){
            if(MES > fecha.getMes()){
                return true;
            } else if(MES == fecha.getMes()){
                return DIA > fecha.getDia();
            }
        }
        return false;
    }

    @Override
    public String toString(){
        return DIA + "/" + MES + "/" + ANIO;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Fecha){
            Fecha fecha = (Fecha) obj;
            return this.toString().equals(fecha.toString());
        }
        return false;
    }
}
