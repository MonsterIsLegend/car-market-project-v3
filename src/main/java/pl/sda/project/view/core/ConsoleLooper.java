package pl.sda.project.view.core;


public class ConsoleLooper {
    private final ConsoleView view;

    public ConsoleLooper(ConsoleView view) {
        this.view = view;
    }

    public void runLoop(){
        while(true){
            if (!view.printAndSelectMenuOption()){
                view.printMessage("Brak takiej opcji!");
            }
        }
    }
}
