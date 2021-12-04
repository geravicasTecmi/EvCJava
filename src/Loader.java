import java.io.*;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashMap;

public class Loader {
    final static String filePathDoc = "src/db/Doctores.csv";
    final static String filePathPac = "src/db/Pacientes.csv";
    final static String filePathCitas = "src/db/Citas.csv";
    final static String filePathUsers = "src/db/Usuarios.csv";

    ArrayList<Doctores> doctoresArrayList = new ArrayList<>();
    ArrayList<Paciente> pacientesArrayList = new ArrayList<>();
    ArrayList<Cita> citasArrayList = new ArrayList<>();
    HashMap<String, String> usuariosHash = new HashMap<>();

    public void load (){
        verify();
        BufferedReader br = null;

        try {
            int i=0;
            br = new BufferedReader(new FileReader(filePathDoc));

            String line = null;
            while ((line = br.readLine()) != null) {

                String[] parts = line.split(",");
                String docID = parts[0].trim();
                String docNombre = parts[1].trim();
                String docEspecialidad = parts[2].trim();

                if (!docID.equals("") && !docNombre.equals("") && !docEspecialidad.equals("")){
                    Doctores doctor = new Doctores();
                    doctor.setDocID(docID);
                    doctor.setDocNombre(docNombre);
                    doctor.setDocEspecialidad(docEspecialidad);
                    doctoresArrayList.add(doctor);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                    System.out.println("IOException catched while closing: " + e.getMessage());
                }
            }
        }

        br = null;

        try {
            int i=0;
            br = new BufferedReader(new FileReader(filePathCitas));

            String line = null;
            while ((line = br.readLine()) != null) {

                String[] parts = line.split(",");
                String citaID = parts[0].trim();
                String citaFecha = parts[1].trim();
                String citaHora = parts[2].trim();
                String citaPacienteID = parts[3].trim();
                String citaDoctorID = parts[4].trim();
                String citaMotivo = parts[5].trim();

                if (!citaID.equals("") && !citaFecha.equals("") && !citaHora.equals("") && !citaPacienteID.equals("")
                        && !citaDoctorID.equals("") && !citaMotivo.equals("")){
                    Cita cita = new Cita(citaID,citaFecha,citaHora,citaPacienteID,citaDoctorID,citaMotivo);
                    citasArrayList.add(cita);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                    System.out.println("IOException catched while closing: " + e.getMessage());
                }
            }
        }

        br = null;

        try {
            int i=0;
            br = new BufferedReader(new FileReader(filePathPac));

            String line = null;
            while ((line = br.readLine()) != null) {

                String[] parts = line.split(",");
                String pacID = parts[0].trim();
                String pacNombre = parts[1].trim();

                if (!pacID.equals("") && !pacNombre.equals("")){
                    Paciente paciente = new Paciente();
                    paciente.setPacID(pacID);
                    paciente.setPacNombre(pacNombre);
                    pacientesArrayList.add(paciente);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                    System.out.println("IOException catched while closing: " + e.getMessage());
                }
            }
        }

        br = null;

        try {
            int i=0;
            br = new BufferedReader(new FileReader(filePathUsers));
            usuariosHash.put("admin","1234");

            String line = null;
            while ((line = br.readLine()) != null) {

                String[] parts = line.split(",");
                String user= parts[0].trim();
                String password = parts[1].trim();

                if (!user.equals("") && !password.equals("")){
                    usuariosHash.put(user,password);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                    System.out.println("IOException catched while closing: " + e.getMessage());
                }
            }
        }
    }

    public void save(){
        verify();
        BufferedWriter bw = null;

        try{
            bw = new BufferedWriter(new FileWriter(filePathDoc));

            for (int i=0; i<doctoresArrayList.size(); i++){
                String docID = doctoresArrayList.get(i).getDocID();
                String docNombre = doctoresArrayList.get(i).getDocNombre();
                String docEspecialidad = doctoresArrayList.get(i).getDocEspecialidad();
                String output = String.format((docID +"," +docNombre +"," +docEspecialidad));
                bw.write(output +"\n");
            }
        } catch (IOException e){
            System.out.println("IOException catched while reading: " + e.getMessage());
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                System.out.println("IOException catched while closing: " + e.getMessage());
            }
        }

        bw = null;
        try{
            bw = new BufferedWriter(new FileWriter(filePathPac));

            for (int i=0; i<pacientesArrayList.size(); i++){
                String pacID = pacientesArrayList.get(i).getPacID();
                String pacNombre = pacientesArrayList.get(i).getPacNombre();
                String output = String.format((pacID +"," +pacNombre));
                bw.write(output +"\n");
            }
        } catch (IOException e){
            System.out.println("IOException catched while reading: " + e.getMessage());
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                System.out.println("IOException catched while closing: " + e.getMessage());
            }
        }

        bw = null;
        try{
            bw = new BufferedWriter(new FileWriter(filePathCitas));

            for (int i=0; i<citasArrayList.size(); i++){
                String citaID = citasArrayList.get(i).getCitaID();
                String citaFecha = citasArrayList.get(i).getCitaFecha();
                String citaHora = citasArrayList.get(i).getCitaHora();
                String citaPacienteID = citasArrayList.get(i).getCitaPacienteID();
                String citaDoctorID = citasArrayList.get(i).getCitaDoctorID();
                String citaMotivo = citasArrayList.get(i).getCitaMotivo();

                String output = String.format((citaID +"," +citaFecha +"," +citaHora +"," +citaPacienteID
                +"," +citaDoctorID +","+citaMotivo));
                bw.write(output +"\n");
            }
        } catch (IOException e){
            System.out.println("IOException catched while reading: " + e.getMessage());
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                System.out.println("IOException catched while closing: " + e.getMessage());
            }
        }
    }

    public void verify(){
        String[] filePaths = {filePathDoc,filePathPac,filePathCitas,filePathUsers};
        for(int i=0; i<4; i++){
            File archivo = new File(filePaths[i]);
            if (!archivo.exists()) {
                create(filePaths[i]);
                System.out.println("¡AVISO! No existe archivo " +filePaths[i] +" este se creó de nuevo.");
            }
        }
    }

    public void create (String fileName){
        Formatter archivo = null;
        try{
            archivo = new Formatter(fileName);
        } catch (Exception e){
            System.out.println("Ha ocurrido un error al crear el archivo: " +e.getMessage());
        } finally {
            archivo.close();
        }
    }
}
