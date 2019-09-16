package Lines.Data;

import Lines.Conditions.TaskConditions;
import Lines.Exceptions.OutOfTaskConditionsException;

public class Service {
    private Boolean allOfTheServices;
    private Integer serviceId;
    private Integer variationId;

    public Service(String serviceData) throws OutOfTaskConditionsException {
        String[] cd = serviceData.split(".");

        if (cd.length > 0) {
            if (cd[0] == "*") {
                allOfTheServices = true;
            } else {
                serviceId = validate(cd[0], TaskConditions.SERVICES_AMOUNT);
            }
        }
        if (cd.length > 1) {
            variationId = validate(cd[1], TaskConditions.VARIATIONS_AMOUNT);
        }
    }

    private static int validate(String inputData, int condition) throws OutOfTaskConditionsException {
        int input = Integer.parseInt(inputData);

        if (input > 0 && input <= condition) {
            return input;
        } else {
            throw new OutOfTaskConditionsException();
        }
    }

    public Boolean getAllOfTheServices() {
        return allOfTheServices;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public Integer getVariationId() {
        return variationId;
    }
}
