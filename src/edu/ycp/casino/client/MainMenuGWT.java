package edu.ycp.casino.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.LayoutPanel;

import edu.ycp.casino.shared.MainMenuController;
import edu.ycp.casino.shared.Observable;
import edu.ycp.casino.shared.Observer;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class MainMenuGWT extends Composite implements Observer {
	private Button btnSlots;
	private Button btnPoker;
	private Button btnBlackJack;
	private Button btnRoulette;
	
	private MainMenuController controller;
	
	public MainMenuGWT() {
		
		LayoutPanel layoutPanel = new LayoutPanel();
		
		initWidget(layoutPanel);
		
		Label lblWhichGameWould = new Label("Which Game Would You Like To Play?");
		layoutPanel.add(lblWhichGameWould);
		layoutPanel.setWidgetLeftWidth(lblWhichGameWould, 119.0, Unit.PX, 198.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblWhichGameWould, 27.0, Unit.PX, 34.0, Unit.PX);
		
		btnSlots = new Button("Slots");
		btnSlots.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				runSlotsClick();
			}
		});
		layoutPanel.add(btnSlots);
		layoutPanel.setWidgetLeftWidth(btnSlots, 36.0, Unit.PX, 149.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(btnSlots, 110.0, Unit.PX, 54.0, Unit.PX);
		
		btnPoker = new Button("Poker");
		btnPoker.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				runPokerClick();
			}
		});
		layoutPanel.add(btnPoker);
		layoutPanel.setWidgetLeftWidth(btnPoker, 249.0, Unit.PX, 149.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(btnPoker, 110.0, Unit.PX, 54.0, Unit.PX);
		
		btnRoulette = new Button("Roulette");
		btnRoulette.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				runRouletteClick();
			}
		});
		layoutPanel.add(btnRoulette);
		layoutPanel.setWidgetLeftWidth(btnRoulette, 36.0, Unit.PX, 149.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(btnRoulette, 219.0, Unit.PX, 54.0, Unit.PX);
		
		btnBlackJack = new Button("Black Jack");
		btnBlackJack.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				runBlackJack();
			}
		});
		layoutPanel.add(btnBlackJack);
		layoutPanel.setWidgetLeftWidth(btnBlackJack, 249.0, Unit.PX, 149.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(btnBlackJack, 219.0, Unit.PX, 54.0, Unit.PX);
	}

	public void runSlotsClick()
	{
		
	}
	
	public void runPokerClick()
	{
		
	}
	
	public void runRouletteClick()
	{
		
	}
	
	public void runBlackJack()
	{
		
	}
	
	public void setController(MainMenuController mm)
	{
		this.controller = mm;
	}
	
	@Override
	public void update(Observable obj, Object hint) {
		// TODO Auto-generated method stub
		
	}
}
