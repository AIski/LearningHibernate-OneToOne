package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.Instant;


public class CreateDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        //create a session
        Session session = factory.getCurrentSession();

        try {
            //create the objects
            Instructor tempInstructor = new Instructor(
                    "Joe",
                    "Spike",
                    "Spikes@bloob.com");

            InstructorDetail tempInstructorDetail = new InstructorDetail("SpikyJoey", "Cats");

            //associate the objects
            tempInstructor.setInstructorDetail(tempInstructorDetail);

            //start transaction
            session.beginTransaction();

            //save the instructor
            //becouse of CascadeType.All, you need only to sav tempInstructor
            // tempInstructorDetail will be saved automatically
            session.save(tempInstructor);

            //commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
            System.out.println("Closing the factory.");
        }


    }
}
