package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        //create a session
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        try {
            // get instructor by ID
            int theID = 3;
            Instructor tempInstructor= session.get(Instructor.class, theID);
            //start transaction

            // delete the instructor
            //becouse of CascadeType.All, you need only to delete tempInstructor
            // tempInstructorDetail will be deleted automatically
            session.delete(tempInstructor);

            //commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");
            System.out.println("Deleted Instructor: "+ tempInstructor);
        } finally {
            factory.close();
            System.out.println("Closing the factory.");
        }


    }
}
