package com.ecodeup.jdbc;

//import static Conexion.Conexion.ConectarDB;

import ClaseTablas.Estudiante;
import ClaseTablas.Inscripcion;
import ClaseTablas.Materias;
import ClaseTablas.Notas;
import Dao.EstudianteDao;
import Dao.InscripcionDao;
import Dao.MateriaDao;
import Dao.NotasDao;
import EjecutarDao.EjecEstudianteDao;
import EjecutarDao.EjecMateriaDao;
import EjecutarDao.EjecutarInscripcion;
import EjecutarDao.EjecutarNotas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Logger;


public class FramePrincipal extends JFrame {
    Logger logger = Logger.getLogger(FramePrincipal.class.getName());

    public FramePrincipal() {
        // Crear los JFrames y JTextAreas fuera de los ActionListener
        JFrame frameMateria = new JFrame("Materias");
        frameMateria.setMinimumSize(new Dimension(300, 360));
        JTextArea textAreaMateria = new JTextArea();


        JFrame frameEstudiante = new JFrame("Estudiantes");
        frameEstudiante.setMinimumSize(new Dimension(300, 360));
        JTextArea textAreaEstudiante = new JTextArea();


        JFrame frameEstudiantesEnMateria = new JFrame("Estudiantes en Materia");
        frameEstudiantesEnMateria.setMinimumSize(new Dimension(300, 360));
        JTextArea textAreaEstudiantesEnMateria = new JTextArea();

        //JFrame framenotasB = new JFrame("Notas");
        //framenotasB.setMinimumSize(new Dimension(300,360));
        JTextArea textAreaNotas = new JTextArea();

        JFrame framenotasCal = new JFrame("Promedio Notas");
        framenotasCal.setMinimumSize(new Dimension(300,360));
        JTextArea textAreaNotasCalcular = new JTextArea();

        JFrame frameBuscar = new JFrame("Buscador de Estudiantes");
        frameBuscar.setMinimumSize(new Dimension(300, 360));
        JTextArea textAreaEstudianteBuscado = new JTextArea();
        // Crear el menú
        JMenuBar menuBar = new JMenuBar();

        // Crear las opciones del menú
        JMenu menuMaterias = new JMenu("Materias");
        JMenu menuEstudiantes = new JMenu("Estudiantes");
        JMenu menuNotas = new JMenu("Notas");

        // Crear las acciones del menú
        JMenuItem verMaterias = new JMenuItem("Ver materias");
        JMenuItem eliminarMateria = new JMenuItem("Eliminar materia");
        JMenuItem verEstudiantes = new JMenuItem("Ver estudiantes");
        JMenuItem inscribirEstudianteMateria = new JMenuItem("Inscribir estudiantes en Materias");

        JMenuItem BuscarEstudianMateria = new JMenuItem("Buscar materias del estudiante");

        JMenuItem verNotas = new JMenuItem("Ver Notas");
        JMenuItem calcularNotas = new JMenuItem("Calcular Notas Estudiante");
        //JMenuItem insertNotas = new JMenuItem("Ingresar Notas");

        // Crear las opciones del submenú "Gestionar estudiantes"
        JMenuItem inscripcionEstudiante = new JMenuItem("Inscribir");
        JMenuItem eliminarEstudiante = new JMenuItem("Eliminar");
        JMenuItem ActualizarEstudiante = new JMenuItem("Modificacion");
        JMenuItem BuscarEstudiante = new JMenuItem("Buscar");


        // Crear el submenú "Gestionar estudiantes" y agregar las opciones
        JMenu administarEstudiantes = new JMenu("Administracion de estudiantes");
        administarEstudiantes.add(inscripcionEstudiante);
        administarEstudiantes.add(eliminarEstudiante);
        administarEstudiantes.add(ActualizarEstudiante);
        administarEstudiantes.add(BuscarEstudiante);

        // Agregar las acciones a las opciones del menú
        menuMaterias.add(verMaterias);
        menuMaterias.add(eliminarMateria);
        menuMaterias.add(inscribirEstudianteMateria);
        menuMaterias.add(BuscarEstudianMateria);
        menuEstudiantes.add(verEstudiantes);
        menuEstudiantes.add(administarEstudiantes);
        menuNotas.add(verNotas);
        menuNotas.add(calcularNotas);
        //menuNotas.add(insertNotas);

        // Agregar las opciones del menú a la barra de menú
        menuBar.add(menuMaterias);
        menuBar.add(menuEstudiantes);
        menuBar.add(menuNotas);

        // Configurar la barra de menú del JFrame
        this.setJMenuBar(menuBar);


        verMaterias.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Limpiar el JTextArea
                textAreaMateria.setText("");

                // Implementar la lógica para ver las materias de la base de datos
                // Obtén una instancia de MateriaDAO
                MateriaDao materiaDAO = new EjecMateriaDao();

                // Obtén todas las materias
                java.util.List<Materias> materias = materiaDAO.getAllMaterias();

                // Muestra las materias al usuario
                for (Materias materia : materias) {
                    //Muestra en una nueva ventana pequeña
                    textAreaMateria.append(materia.getCodigoMaterias()+ ".- " + materia.getNombre() + "\n");
                }
                frameMateria.getContentPane().add(textAreaMateria);
                frameMateria.setVisible(true);
            }
        });

        eliminarMateria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String materiaID = JOptionPane.showInputDialog("ID de la Materia a eliminar: ");

                int materiaId = Integer.parseInt(materiaID);

                Materias MateriaEliminr = new Materias(materiaId,null,null);

                MateriaDao materiaDao = new EjecMateriaDao();
                materiaDao.deleteMateria(MateriaEliminr);

                JOptionPane.showMessageDialog(null, "Estudiante eliminado exitosamente");
            }
        });

        verEstudiantes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Limpiar el JTextArea
                textAreaEstudiante.setText("");

                // Implementar la lógica para ver los estudiantes de la base de datos
                // Obtén una instancia de EstudianteDAO
                EstudianteDao estudianteDAO = new EjecEstudianteDao();

                // Obtén todos los estudiantes
                java.util.List<Estudiante> estudiantes = estudianteDAO.getAllEstudiantes();

                // Muestra los estudiantes al usuario
                for (Estudiante estudiante : estudiantes) {
                    textAreaEstudiante.append(estudiante.getResgistroEstudiante() + " - "
                            + estudiante.getNombreCompleto() + " --> " +estudiante.getCarrera() +"\n");
                }
                frameEstudiante.getContentPane().add(textAreaEstudiante);
                frameEstudiante.setVisible(true);
            }

        });

        verNotas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String RegistroEstudiante = JOptionPane.showInputDialog("ID del estudiante : ");
                int studentId = Integer.parseInt(RegistroEstudiante);

                Notas notas = new Notas(studentId);

                NotasDao notasDao = new EjecutarNotas();
                notasDao.verNotas(notas);


                // Hacer visible el frame
                //framenotasB.getContentPane().add(textAreaNotas);
                //framenotasB.setVisible(true);
            }
        });

        calcularNotas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String RegistroEstudiante = JOptionPane.showInputDialog("ID del estudiante : ");
                String CodeMateria = JOptionPane.showInputDialog("Codigo de la Materia: ");

                int studentId = Integer.parseInt(RegistroEstudiante);
                int MateriaId = Integer.parseInt(CodeMateria);

                Notas notasCalcular = new Notas(studentId,MateriaId);

                NotasDao notasDao = new EjecutarNotas();
                notasDao.CalcularNotas(notasCalcular);

            }
        });



        JMenuItem verEstudiantesMaterias = new JMenuItem("Ver Estudiantes en Materias");
        menuMaterias.add(verEstudiantesMaterias);

        JFrame frameEstudiantesMaterias = new JFrame("Estudiantes en Materias");
        frameEstudiantesMaterias.setMinimumSize(new Dimension(300, 360));

        BuscarEstudianMateria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String RegistroEstudiante = JOptionPane.showInputDialog("ID del estudiante : ");
                int studentId = Integer.parseInt(RegistroEstudiante);

                Inscripcion inscripciones = new Inscripcion(studentId);

                InscripcionDao inscripcionDao = new EjecutarInscripcion();
                inscripcionDao.buscarMateriaEstudiante(inscripciones);
            }
        });
        verEstudiantesMaterias.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Limpiar el JTextArea
                textAreaEstudiantesEnMateria.setText("");

                // Implementar la lógica para ver los estudiantes en las materias
                // Obtén una instancia de EstudianteMateriaDAO
                InscripcionDao estudianteMateriaDao = new EjecutarInscripcion();

                // Obtén todas las relaciones entre estudiantes y materias
                java.util.List<Inscripcion> estudianteMaterias = estudianteMateriaDao.getAllInscripcion();

                // Muestra las relaciones al usuario
                for (Inscripcion estudianteMateria : estudianteMaterias) {
                    textAreaEstudiantesEnMateria.append(
                            estudianteMateria.getNombreEstudiante() + " ---> " + estudianteMateria.getNombreMaterias() + "\n");
                }
                frameEstudiantesMaterias.getContentPane().add(textAreaEstudiantesEnMateria);
                frameEstudiantesMaterias.setVisible(true);
            }
        });


        inscribirEstudianteMateria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the student's ID and the subject's ID
                String studentIdInput = JOptionPane.showInputDialog("ID del estudiante:");
                String subjectIdInput = JOptionPane.showInputDialog("ID de la materia:");

                // Convert the inputs to integers
                int studentId = Integer.parseInt(studentIdInput);
                int subjectId = Integer.parseInt(subjectIdInput);

                // Create a new instance of EstudianteMateria
                Inscripcion newEnrollment = new Inscripcion (studentId, subjectId);

                // Insert this new instance into the database
                // You need to create a method in EstudianteMateriaDaoImpl for this
                InscripcionDao estudianteMateriaDao = new EjecutarInscripcion();
                estudianteMateriaDao.insertInscripcion(newEnrollment);
                JOptionPane.showMessageDialog(null, "Incripcion exitosa");
            }
        });



        inscripcionEstudiante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the student's details
                String studentIdInput = JOptionPane.showInputDialog("ID del estudiante: ");
                String studentNameInput = JOptionPane.showInputDialog("Nombre del estudiante: ");
                String studentBirthDateInput = JOptionPane.showInputDialog("Fecha de nacimiento del estudiante: ");
                String studentCarreraInput = JOptionPane.showInputDialog("Carrera del estudiante: ");

                // Convert the inputs to appropriate data types
                int studentId = Integer.parseInt(studentIdInput);

                // Create a new instance of Estudiante
                Estudiante newStudent = new Estudiante(studentId, studentNameInput, studentBirthDateInput,studentCarreraInput);


                EstudianteDao estudianteDao = new EjecEstudianteDao();
                estudianteDao.createEstudiante(newStudent);

                JOptionPane.showMessageDialog(null, "Estudiante creado exitosamente");
            }
        });


        eliminarEstudiante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the student's ID
                String studentIdInput = JOptionPane.showInputDialog("ID del estudiante a eliminar: ");

                // Convert the input to an integer
                int studentId = Integer.parseInt(studentIdInput);

                // Create a new instance of Estudiante
                Estudiante studentToDelete = new Estudiante(studentId, null, null, null);

                // Delete this student from the database
                // You need to create a method in EstudianteDaoImpl for this
                EstudianteDao estudianteDao = new EjecEstudianteDao();
                estudianteDao.deleteEstudiante(studentToDelete);

                JOptionPane.showMessageDialog(null, "Estudiante eliminado exitosamente");
            }
        });
        ActualizarEstudiante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the student's ID and new details
                String studentIdInput = JOptionPane.showInputDialog("ID del estudiante a modificar: ");
                String newStudentNameInput = JOptionPane.showInputDialog("Nuevo nombre del estudiante: ");
                String studentCarreraInput = JOptionPane.showInputDialog("Carrera del estudiante: ");

                // Convert the inputs to appropriate data types
                int studentId = Integer.parseInt(studentIdInput);

                // Create a new instance of Estudiante with the new details
                Estudiante studentToUpdate = new Estudiante(studentId, newStudentNameInput, null,studentCarreraInput);

                // Update this student in the database
                // You need to create a method in EstudianteDaoImpl for this
                EstudianteDao estudianteDao = new EjecEstudianteDao();
                estudianteDao.updateEstudiante(studentToUpdate);

                JOptionPane.showMessageDialog(null, "Estudiante modificado exitosamente");


            }
        });





        //Un metodo buscar estudiante que le pase el nombre por un JOptionPane que cuando le ponga el nombre me bote una lista de las materias que si eta inscrito el alumno
        BuscarEstudiante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String studentIdInput = JOptionPane.showInputDialog("ID del estudiante : ");
                String studentNameInput = JOptionPane.showInputDialog("Nombre del estudiante: ");

                int studentId = Integer.parseInt(studentIdInput);

                Estudiante studentToSearch = new Estudiante(studentId, studentNameInput, null,null);


                EstudianteDao estudianteDao = new EjecEstudianteDao();
                estudianteDao.searchEstudiante(studentToSearch);

                JOptionPane.showMessageDialog(null, "Estudiante encontrado exitosamente");

                textAreaEstudianteBuscado.setText("");


                EstudianteDao estudianteDAO = new EjecEstudianteDao();
                MateriaDao materiaDAO = new EjecMateriaDao();

                // Obtén todos los estudiantes
                java.util.List<Estudiante> estudiantes = estudianteDAO.getAllEstudiantes();
                // Obtén todas las materias
                List<Materias> materias = materiaDAO.getAllMaterias();

                // Muestra los estudiantes al usuario
                for (Estudiante estudiante : estudiantes) {
                    for (Materias materia : materias) {
                        textAreaEstudianteBuscado.append(estudiante.getResgistroEstudiante() + " - " + estudiante.getNombreCompleto() +" - " + materia.getNombre() + "\n");
                    }
                }
                frameBuscar.getContentPane().add(textAreaEstudianteBuscado);
                frameBuscar.setVisible(true);
            }
        });


        // Configurar el JFrame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(750, 600);

        JButton boton = new JButton("Presioname");
        JPanel panelConFondo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Reemplaza "ruta_de_la_imagen.jpg" con la ruta de tu imagen
                ImageIcon imagenFondo = new ImageIcon("Imagenes/pro3.jpg");
                g.drawImage(imagenFondo.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
            //Este boton tiene que abrir un JOptionPane que diga "Pasaste pro 3 :D"

            {
                boton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(null, "Pasaste pro 3 :D", "Sorpresa!!!", JOptionPane.INFORMATION_MESSAGE);
                    }
                });
            }


        };
        boton.setBounds(30, 470, 120, 30);
        // Configurar el diseño del panel
        panelConFondo.setLayout(null);
        panelConFondo.add(boton);


        // Establecer el panelConFondo como el panel principal del JFrame
        this.setContentPane(panelConFondo);

        // Agregar el botón al panel




        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        // Crear una instancia de PanelPrincipal
        FramePrincipal framePrincipal = new FramePrincipal();
        framePrincipal.setVisible(true);
    }
}