package azat.example.cursdemo.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String address;
    private Integer month_inc;
    private String name;
    private String surname;
    private String sec_surname;
    private String passport_ser;
    private String passport_num;
    private String by_who;
    private String ident_num;
    private String birth_place;
    private String city;
    private Integer city_id;
    private String tel;
    private String email;
    private String work_place;
    private String position;
    private String fam_status;
    private Integer fs_id;
    private String residence;
    private Integer residence_id;
    private String disability;
    private Integer disability_id;
    private boolean pensioner;
    private boolean duty_bound;
    private LocalDate birth_date;
    private LocalDate issue_date;


}
