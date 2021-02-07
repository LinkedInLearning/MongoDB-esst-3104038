package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {

	private static final long serialVersionUID = 7160713657316969767L;

	public MainView(@Autowired PersonRepository personRepository) {
		long anzahl = 0; // bitte Variable anzahl mit der Anzahl der Dokumente in der Collection person
							// belegen
		String titel = "Personen (" + anzahl + ")";
		add(new Text(titel));

		Button insertButton = new Button(new Icon(VaadinIcon.PLUS));
		insertButton.addClickListener(event -> {
			// hier bitte ihren Quellcode einfügen
		});
		add(insertButton);

		Grid<Person> grid = new Grid<>(Person.class);
		grid.setItems(personRepository.findAll());
		grid.setColumns("id", "name");
		add(grid);
	}

}
