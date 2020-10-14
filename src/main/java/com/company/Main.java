package com.company;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {
        Configuration configuration=new Configuration().configure().addAnnotatedClass(Student.class);
        ServiceRegistry reg =new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        SessionFactory sf =configuration.buildSessionFactory(reg);
        Session sess = sf.openSession();



        Student temoStudent = new Student("mohamed","adel","ahmedadel@gmail.com");
        Student temoStudent1 = new Student("mohamed","adel","ahmedadel@gmail.com");
        Student temoStudent2 = new Student("mohamed","adel","ahmedadel@gmail.com");
        Student temoStudent3 = new Student("mohamed","adel","ahmedadel@gmail.com");

        Transaction tx = sess.beginTransaction();
        tx.begin();
        sess.save(temoStudent);



//        System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
//        List<Student>listOfStudents= sess.createQuery("from Student").list();
//        System.out.println("lllllllllllllll");
//        display(listOfStudents);
        tx.commit();

//        System.out.println("\n \n\n\n\n\n\n\n\n");
//        sess.beginTransaction();
//        List<Student > newStudentList = sess.createQuery("from Student s where s.id=10").list();
//        display(newStudentList);
//        sess.getTransaction().commit();





//        sess.beginTransaction();
//        sess.createQuery("delete from Student where id=11").executeUpdate();
//        sess.getTransaction().commit();
//        sess.beginTransaction();
//        sess.createQuery("update Student set email='ahmedadelghonim@gmail.com' where id in(1,2,3)").executeUpdate();
//        sess.getTransaction().commit();






        sess.close();
    }

    public static void display(List<Student> list){
        for (Student student : list){
            System.out.println(student);

        }
    }
}
