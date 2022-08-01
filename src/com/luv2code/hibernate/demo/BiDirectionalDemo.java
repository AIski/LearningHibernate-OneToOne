package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class BiDirectionalDemo {
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
            //get the instructorDetail Object

            int theID = 5;
            InstructorDetail tempinstructorDetail=session
                    .get(InstructorDetail.class,theID);

            //print the instructor detail
            System.out.println("tempInstructorDetail: "+ tempinstructorDetail);

            //printthe associated instructor
            System.out.println("the associated instructor: "+ tempinstructorDetail.getTempInstructor());

            session.getTransaction().commit();

            System.out.println("Done! Got bi-directional connection!");

        }
        catch (Exception e){
            e.printStackTrace();
        }

            finally {
            session.close();
            factory.close();
            System.out.println("Closing the factory.");
        }


    }
}
