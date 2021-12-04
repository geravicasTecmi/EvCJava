import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Loader loader = new Loader();
        loader.load();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa el usuario para acceder al sistema: ");
        String user=scanner.nextLine();

        if(loader.usuariosHash.containsKey(user)){

            System.out.print("Ingresa la contraseña: ");
            String password=scanner.nextLine();
            String userRegisteredPassword =loader.usuariosHash.get(user);

            if (password.equals(userRegisteredPassword)){
                boolean exit = true;
                int opcion;

                do{
                    try{
                        opcion=showMenu();

                        switch (opcion){
                            case 1:
                                String docID = String.format("DOC-"+(loader.doctoresArrayList.size()+1));
                                System.out.print("Ingresa el nombre del doctor: ");
                                String docNombre = scanner.nextLine();
                                System.out.print("Ingresa la especialidad del doctor: ");
                                String docEspecialidad =scanner.nextLine();


                                Doctores doctor = new Doctores();
                                doctor.setDocID(docID);
                                doctor.setDocNombre(docNombre);
                                doctor.setDocEspecialidad(docEspecialidad);
                                loader.doctoresArrayList.add(doctor);
                                break;

                            case 2:
                                String pacID = String.format("PAC-"+(loader.pacientesArrayList.size()+1));
                                System.out.print("Ingresa el nombre del paciente: ");
                                String pacNombre = scanner.nextLine();

                                Paciente paciente = new Paciente();
                                paciente.setPacID(pacID);
                                paciente.setPacNombre(pacNombre);
                                loader.pacientesArrayList.add(paciente);
                                break;

                            case 3:
                                String citaID = String.format("CITA-"+(loader.citasArrayList.size()+1));
                                System.out.print("Ingresa la fecha de la cita en formato dd/mm/aa: ");
                                String citaFecha = scanner.nextLine();
                                System.out.print("Ingresa la hota de la cita en formato 24h: ");
                                String citaHora = scanner.nextLine();
                                System.out.println("Selecciona el número de paciente para la cita: \n");
                                System.out.println("NUM \t ID DE PACIENTE \t NOMBRE DEL PACIENTE");

                                for (int i=0; i<loader.pacientesArrayList.size(); i++){
                                    String output= String.format((i+1) +"\t\t\t" +loader.pacientesArrayList.get(i).getPacID() +"\t\t\t\t"
                                            +loader.pacientesArrayList.get(i).getPacNombre());
                                    System.out.println(output);
                                }
                                String selecID = scanner.nextLine();
                                int SelecID = Integer.parseInt(selecID);
                                SelecID=SelecID-1;
                                String citaPacienteID =loader.pacientesArrayList.get(SelecID).getPacID();

                                System.out.println("Selecciona el número de dcotor para la cita: \n");
                                System.out.println("NUM \t ID DE DOCTOR \t NOMBRE DEL DOCTOR \t ESPECIALIDAD");

                                for (int i=0; i<loader.doctoresArrayList.size(); i++){
                                    String output= String.format((i+1) +"\t\t\t" +loader.doctoresArrayList.get(i).getDocID() +"\t\t\t"
                                            +loader.doctoresArrayList.get(i).getDocNombre() +"\t\t" +
                                            loader.doctoresArrayList.get(i).getDocEspecialidad());
                                    System.out.println(output);
                                }
                                selecID = scanner.nextLine();
                                SelecID = Integer.parseInt(selecID);
                                SelecID=SelecID-1;
                                String citaDoctorID =loader.doctoresArrayList.get(SelecID).getDocID();

                                System.out.print("Ingresa el motivo de la cita: ");
                                String citaMotivo = scanner.nextLine();

                                Cita cita = new Cita(citaID,citaFecha,citaHora,citaPacienteID,citaDoctorID,citaMotivo);
                                loader.citasArrayList.add(cita);
                                break;
                            case 4:
                                System.out.println("DOCTORES: \n");
                                System.out.println("NUM \t ID DE DOCTOR \t NOMBRE DEL DOCTOR \t ESPECIALIDAD");

                                for (int i=0; i<loader.doctoresArrayList.size(); i++){
                                    String output= String.format((i+1) +"\t\t\t" +loader.doctoresArrayList.get(i).getDocID() +"\t\t\t"
                                            +loader.doctoresArrayList.get(i).getDocNombre() +"\t\t" +
                                            loader.doctoresArrayList.get(i).getDocEspecialidad());
                                    System.out.println(output);
                                }
                                break;
                            case 5:
                                System.out.println("PACIENTES: \n");
                                System.out.println("NUM \t ID DE PACIENTE \t NOMBRE DEL PACIENTE");

                                for (int i=0; i<loader.pacientesArrayList.size(); i++){
                                    String output= String.format((i+1) +"\t\t\t" +loader.pacientesArrayList.get(i).getPacID() +"\t\t\t\t"
                                            +loader.pacientesArrayList.get(i).getPacNombre());
                                    System.out.println(output);
                                }
                                break;
                            case 6:
                                System.out.println("CITAS: \n");
                                System.out.println("NUM \t ID DE CITA \t FECHA \t\t HORA \t ID PACIENTE \t ID DOCTOR \t MOTIVO");

                                for (int i=0; i<loader.citasArrayList.size(); i++){
                                    String output= String.format((i+1) +"\t\t\t" +loader.citasArrayList.get(i).getCitaID() +"\t\t"
                                            +loader.citasArrayList.get(i).getCitaFecha() +"\t"
                                            +loader.citasArrayList.get(i).getCitaHora() +"\t\t"
                                            +loader.citasArrayList.get(i).getCitaPacienteID() +"\t\t\t"
                                            +loader.citasArrayList.get(i).getCitaDoctorID() +"\t\t"
                                            +loader.citasArrayList.get(i).getCitaMotivo());
                                    System.out.println(output);
                                }
                                break;
                            case 7:
                                System.out.println("Saliendo...");
                                exit=false;
                                break;
                            default:
                                System.out.println("Error. Opción no válida.");
                                break;
                        }
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                } while (exit);
            } else{
                System.out.println("Contraseña no es correcta.");
            }
        } else{
            System.out.println("Usuario no existe.");
        }
        loader.save();
    }

    public static int showMenu() throws Exception{
        Scanner scanner = new Scanner(System.in);
        int opcion;

        System.out.println("Bienvenido al sistema de citas. Elige una opción del menú:");
        System.out.println("1. Dar de alta doctores.");
        System.out.println("2. Dar de alta pacientes.");
        System.out.println("3. Crear cita.");
        System.out.println("4. Ver doctores.");
        System.out.println("5. Ver pacientes.");
        System.out.println("6. Ver citas.");
        System.out.println("7. Salir.");
        opcion=scanner.nextInt();

        if ((opcion<0)||(opcion>7)){
            throw new Exception("Opción no válida. Ingresa un número del 1 al 4.");
        }
        return opcion;
    }
}
