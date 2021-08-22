package ru.gb;

import static ru.gb.constants.ConsoleCommandConstants.ALL;
import static ru.gb.constants.ConsoleCommandConstants.EXIT;

import java.util.Scanner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.gb.domain.Cart;

@Slf4j
public class Main {

  private static final Scanner SCANNER = new Scanner(System.in);
  private static final ApplicationContext CONTEXT = new AnnotationConfigApplicationContext("ru.gb");

  public static void main(String[] args) {
    log.info("Выберите команду: ");
    log.info("Введите id товара или all");

    String inputCommand;

    while (!isExitCommand(inputCommand = SCANNER.next())) {
      Cart cart = CONTEXT.getBean(Cart.class);
      try {
        int productId = Integer.parseInt(inputCommand);
        cart.putById(productId);
      } catch (NumberFormatException e) {
        if (ALL.equalsIgnoreCase(inputCommand)) {
          cart.putAll();
        } else {
          System.out.println("Некорреткная команда");
        }
      } catch (Exception e) {
        log.error("Ошибка выполнения", e);
      }
    }
  }

  private static boolean isExitCommand(String inputCommand) {
    return EXIT.equalsIgnoreCase(inputCommand);
  }

}
