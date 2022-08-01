package com.luv2code.hibernate.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {

    //fields annotated with table columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "youtube_channel")
    private String youtubeChannel;

    @Column(name = "hobby")
    private String hobby;


    // USED ONLY FOR BI_DIRECTIONAL
    @OneToOne(mappedBy = "instructorDetail", cascade = {CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH})
    private Instructor tempInstructor;

    //constructors
   public InstructorDetail(){
    }

    public InstructorDetail(String youtubeName, String hobby) {
        this.youtubeChannel = youtubeName;
        this.hobby = hobby;
    }

    //getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYoutubeChannel() {
        return youtubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Instructor getTempInstructor() {
        return tempInstructor;
    }

    public void setTempInstructor(Instructor tempInstructor) {
        this.tempInstructor = tempInstructor;
    }
    //toString
    @Override
    public String toString() {
        return "InstructorDetail{" +
                "id=" + id +
                ", youtubeName='" + youtubeChannel + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }



}
