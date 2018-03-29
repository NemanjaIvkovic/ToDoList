package view;

import java.text.ParseException;

public class View {
    /**
     * Represents the <code>View</code> of the application
     *
     * Holds a reference to the <code>Parser</code>
     */



        private Parser parser;

        public View () throws ParseException {
            parser = new Parser();
        }

        /**
         * The main function that keeps the application running until the <code>quit</code> command has been entered by the user
         */

        public void start() throws ParseException {

            boolean finished = false;

            parser.getPrintStart();
            parser.showCommands();

            while (!finished) {
                Command command = parser.getCommand();
                finished = parser.processCommand(command);
            }
            parser.getPrintExit();
        }
}
