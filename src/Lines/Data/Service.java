package Lines.Data;

import Input.TaskConditions;
import Lines.Exceptions.OutOfTaskConditionsException;

public class Service {
    private boolean allOfTheServices;
    private Integer serviceId;
    private Integer variationId;

    private static int validate(String inputData, int condition) throws OutOfTaskConditionsException {
        int input = Integer.parseInt(inputData);

        if (input > 0 && input <= condition) {
            return input;
        } else {
            throw new OutOfTaskConditionsException();
        }
    }

    public Service(String serviceData) throws OutOfTaskConditionsException {
        String[] sd = serviceData.split("\\.");

        if (sd.length > 0) {
            if (sd[0].equals("*")) {
                allOfTheServices = true;
            } else {
                serviceId = validate(sd[0], TaskConditions.SERVICES_AMOUNT);
            }
        }
        if (sd.length > 1) {
            variationId = validate(sd[1], TaskConditions.VARIATIONS_AMOUNT);
        }
    }

    public boolean includes(Service other) {
        return allOfTheServices ||
                ((serviceId.equals(other.serviceId)) &&
                        ((variationId == null) || (variationId.equals(other.variationId))));
    }
}
