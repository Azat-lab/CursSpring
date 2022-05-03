package azat.example.cursdemo.models;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clients")
public class Clients {

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

    public Clients(String address, Integer month_inc, String name, String surname,
                   String sec_surname, String passport_ser, String passport_num,
                   String by_who, String ident_num, String birth_place, String city,
                   Integer city_id, String tel, String email, String work_place,
                   String position, String fam_status, Integer fs_id, String residence,
                   Integer residence_id, String disability, Integer disability_id,
                   boolean pensioner, boolean duty_bound, LocalDate birth_date, LocalDate issue_date) {
    }
}
