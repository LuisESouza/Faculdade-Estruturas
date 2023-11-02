package estruturaarvore;


public class tipoNo {
    public tipoNo maior;
    public tipoNo menor;
    public int info;
    
    public void tipoNo(){
    }

    //GET e SETT maior
    public tipoNo getMaior() {
        return maior;
    }
    public void setMaior(tipoNo maior) {
        this.maior = maior;
    }

    //GET e SETT menor
    public tipoNo getMenor() {
        return menor;
    }
    public void setMenor(tipoNo menor) {
        this.menor = menor;
    }
    
    //GET e SETT info
    public int getInfo() {
        return info;
    }
    public void setInfo(int info) {
        this.info = info;
    }
    
}
