package stores;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.CreditCardNumber;
import java.util.List;
import java.util.ArrayList;
import lombok.Data;
@Data
public class TacoOrder {
@NotBlank(message="Укажите адресата доставки.")
private String deliveryName;
@NotBlank(message="Укажите улицу")
private String deliveryStreet;
@NotBlank(message="Укажите город")
private String deliveryCity;
@NotBlank(message="Укажите регион")
private String deliveryState;
@NotBlank(message="Укажите почновый индекс")
private String deliveryZip;
@CreditCardNumber(message="Недействительный номер кредитной карты")
private String ccNumber;
@Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$",
message="Формат должен быть ММ/ГГ")
private String ccExpiration;
@Digits(integer=3, fraction=0, message="Неверный CVV")
private String ccCVV;
private List<Taco> tacos = new ArrayList<>();
public void addTaco(Taco taco) {
this.tacos.add(taco);
}
}
