package stores.web;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import jakarta.validation.Valid;

import lombok.extern.slf4j.Slf4j;
import stores.Ingredient;
import stores.Taco;
import stores.TacoOrder;
import stores.Ingredient.Type;
import stores.data.IngredientRepository;
@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {
private final IngredientRepository ingredientRepo;
 public DesignTacoController(
 IngredientRepository ingredientRepo) {
 this.ingredientRepo = ingredientRepo;
 }
@ModelAttribute
public void addIngredientsToModel(Model model) {
 Iterable<Ingredient> ingredients = ingredientRepo.findAll();
 Type[] types = Ingredient.Type.values();
 for (Type type : types) {
model.addAttribute(type.toString().toLowerCase(),
filterByType(ingredients, type));
}
 }
@ModelAttribute(name = "tacoOrder")
public TacoOrder order() {
return new TacoOrder();
}
@ModelAttribute(name = "taco")
public Taco taco() {
return new Taco();
}
@GetMapping
public String showDesignForm() {
	
return "design";
}

@PostMapping
public String processTaco(@Valid Taco taco, Errors errors,
@ModelAttribute TacoOrder tacoOrder) {
if (errors.hasErrors()) {
return "design";
}
tacoOrder.addTaco(taco);
log.info("Processing taco: {}", taco);
return "redirect:/orders/current";
}


private Iterable<Ingredient> filterByType(
Iterable<Ingredient> ingredients, Type type) {
return StreamSupport.stream(ingredients.spliterator(),
false)
.filter(i -> i.getType().equals(type))
.collect(Collectors.toList());
}
}