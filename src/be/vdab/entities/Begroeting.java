package be.vdab.entities;
import java.util.Calendar;
public class Begroeting {
  @Override 
  public String toString() {	  
	  return(isOpen() ? "open" : "gesloten");
  }

  private boolean isOpen(){
	  int dagVanDeWeek = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
	  return (!(dagVanDeWeek ==  Calendar.MONDAY || dagVanDeWeek == Calendar.THURSDAY));
  }
} 