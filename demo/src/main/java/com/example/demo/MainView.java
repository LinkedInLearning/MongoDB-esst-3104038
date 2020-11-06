package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {

	private static final long serialVersionUID = 7160713657316969767L;

	public MainView(@Autowired PersonRepository personRepository) {
		add(new Text("Personen"));
		Grid<Person> grid = new Grid<>(Person.class);
		grid.setItems(personRepository.findAll());
		grid.setColumns("id", "name");
		add(grid);
	}

}
