package stores.web;
import java.util.HashMap;
import java.util.Map;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import stores.Ingredient;
import stores.Ingredient.Type;
import stores.data.IngredientRepository;
@Component
public class IngredientByIdConverter implements Converter<String,
Ingredient>{
private IngredientRepository ingredientRepo;
public IngredientByIdConverter(IngredientRepository
ingredientRepo) {
 this.ingredientRepo = ingredientRepo;
 }
@Override
public Ingredient convert(String id) {
 return ingredientRepo.findById(id).orElse(null);
 }
}
