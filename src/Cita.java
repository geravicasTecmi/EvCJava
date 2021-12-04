public class Cita {
    String citaID;
    String citaFecha;
    String citaHora;
    String citaPacienteID;
    String citaDoctorID;
    String citaMotivo;

    public Cita(String citaID, String citaFecha, String citaHora, String citaPacienteID, String citaDoctorID,
                String citaMotivo){
        this.citaID=citaID;
        this.citaFecha=citaFecha;
        this.citaHora=citaHora;
        this.citaPacienteID=citaPacienteID;
        this.citaDoctorID=citaDoctorID;
        this.citaMotivo=citaMotivo;
    }

    public void setCitaID(String citaID){
        this.citaID=citaID;
    }

    public void setCitaFecha(String citaFecha){
        this.citaFecha=citaFecha;
    }

    public void setCitaHora(String citaHora){
        this.citaHora=citaHora;
    }

    public void setCitaPacienteID (String citaPacienteID){
        this.citaPacienteID=citaPacienteID;
    }

    public void setCitaDoctorID (String citaDoctorID){
        this.citaDoctorID=citaDoctorID;
    }

    public void setCitaMotivo (String citaMotivo){
        this.citaMotivo=citaMotivo;
    }

    public String getCitaID(){
        return citaID;
    }

    public String getCitaFecha(){
        return citaFecha;
    }

    public String getCitaHora(){
        return citaHora;
    }

    public String getCitaPacienteID(){
        return citaPacienteID;
    }

    public String getCitaDoctorID(){
        return citaDoctorID;
    }

    public String getCitaMotivo(){
        return citaMotivo;
    }
}
