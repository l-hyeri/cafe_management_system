/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package design_project.cake;

/**
 *
 * @author 윤채민
 */
public class blueberryCake extends cake {
  private cakeIngredientFactory ingredientFactory;

  public blueberryCake(cakeIngredientFactory ingredientFactory) {
      this.ingredientFactory = ingredientFactory;
  }
  
  public void cook(){
      this.fruit = ingredientFactory.createFruit();
      this.topping = ingredientFactory.createTopping();
  }
}