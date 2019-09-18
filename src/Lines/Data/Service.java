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
//        System.out.println(serviceData);
        String[] sd = serviceData.split("\\.");

        if (sd.length > 0) {
            if (sd[0].equals("*")) {
                allOfTheServices = true;
            } else {
                serviceId = validate(sd[0], TaskConditions.SERVICES_AMOUNT);
                System.out.println(serviceId);
            }
        }
        if (sd.length > 1) {
            variationId = validate(sd[1], TaskConditions.VARIATIONS_AMOUNT);
            System.out.println(variationId);
        }
    }

    public boolean includes(Service other) {
        return allOfTheServices ||
                ((serviceId == other.serviceId) &&
                        ((variationId == null) || (variationId == other.variationId)));
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
