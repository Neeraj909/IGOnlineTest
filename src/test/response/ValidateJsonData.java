
public class ValidateJsonData {
        private EmployeeData[] employeeData;

        private String message;

        private String status;

        public EmployeeData[] getEmployeeData ()
        {
            return employeeData;
        }

        public void setEmployeeData (EmployeeData[] employeeData)
        {
            this.employeeData = employeeData;
        }

        public String getMessage ()
        {
            return message;
        }

        public void setMessage (String message)
        {
            this.message = message;
        }

        public String getStatus ()
        {
            return status;
        }

        public void setStatus (String status)
        {
            this.status = status;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [employeeData = "+employeeData+", message = "+message+", status = "+status+"]";
        }
    }


