package edu.ycp.casino.shared;

import edu.ycp.casino.client.SlotsViewGWT;


public class SlotsController {
	
		Slots model;
		SlotsViewGWT view;
		
		public SlotsController()
		{
		}
		
		public void assignPot(int m)
		{
			//model.bet = m;
		}
	
	
		public void spinHandler()
		{
//			model.spin();
//			
//			if(model.checkWin() == true)
//			{
//				model.setMoney(model.getMoney() + model.bet);
//			}
//			
//			if(model.checkWin() == false)
//			{
//				model.setMoney(model.getMoney() - model.bet);
//			}
		}
		
		public void setModel(Slots model)
		{
			this.model = model;
		}
		
		public void setView(SlotsViewGWT slotsView)
		{
			this.view = slotsView;
		}
		
}
