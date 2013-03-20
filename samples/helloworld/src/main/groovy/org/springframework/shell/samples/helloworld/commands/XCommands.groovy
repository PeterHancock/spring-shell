package org.springframework.shell.samples.helloworld.commands;

import java.util.logging.Level;


import org.springframework.shell.core.CommandMarker;
import org.springframework.shell.core.Shell;
import org.springframework.shell.core.annotation.CliAvailabilityIndicator;
import org.springframework.shell.core.annotation.CliCommand;
import org.springframework.shell.core.annotation.CliOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class XCommands implements CommandMarker {
	
  @Autowired
  private Shell shell;
  
	private boolean simpleCommandExecuted = false;
	
	@CliAvailabilityIndicator(["x"])
	public boolean isSimpleAvailable() {
		//always available
		return true;
	}
		
	@CliCommand(value = "x", help = "x help")
	public String x(
  @CliOption(key = [ "message" ], mandatory = true, help = "The hello world message") final String message) {		
    (1..20).each {
      shell.flash(Level.INFO, '.' * it, 'x')
      //Thread.sleep(150);
      println 'working...'
    }
		return "Message = $message";
	}
	
}