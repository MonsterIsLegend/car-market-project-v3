package pl.sda.project.view.domain;



import pl.sda.project.domain.AnnoucmentForUser;

import java.util.List;

public class PrintAllAnnoucmentsInConsole {

    private List<AnnoucmentForUser> allAnnoucments;

    public PrintAllAnnoucmentsInConsole(List<AnnoucmentForUser> allAnnoucments) {
        this.allAnnoucments = allAnnoucments;
    }

    public void printAllAnnoucments(){
        allAnnoucments.forEach(System.out::println);
    }
}
