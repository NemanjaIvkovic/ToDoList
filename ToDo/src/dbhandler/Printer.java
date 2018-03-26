package dbhandler;

import java.util.List;

import integration.InspectionInfoDTO;
import integration.ReceiptDTO;

public class Printer {
	public Printer() {
    }

    /**
     *
     * @param receipt hold all the receipt information.
     */
    public void printReceipt(ReceiptDTO receipt) {
        System.out.println("RegNumber:" + receipt.getRegNumber());
        System.out.println("ReceiptDate:" + receipt.getReceiptDate());
        System.out.println("Cost:" + receipt.getCost());
      
    }

    /**
     *
     * @param inspectionResult this parameter will hold the inspection results.
     */
    public void printInspectionResult(List<InspectionInfoDTO> inspectionResult) {
        System.out.println("Inspection results:");
        for (InspectionInfoDTO ins : inspectionResult) {
            System.out.println(ins.getInspectionInformation() + ":" + (ins.getInspectionResult() ? "pass" : "fail"));
        }
    }
}
