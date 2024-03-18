import java.util.Scanner;

public class CrimePrediction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the Advanced Crime Prediction Program!");

        // Input location data
        System.out.print("Enter population density (people/sq mile): ");
        double populationDensity = scanner.nextDouble();
        System.out.print("Enter unemployment rate (%): ");
        double unemploymentRate = scanner.nextDouble();
        System.out.print("Enter average income ($): ");
        double averageIncome = scanner.nextDouble();
        System.out.print("Enter education level (% high school): ");
        double educationLevel = scanner.nextDouble();
        System.out.print("Enter law enforcement officers per 10,000 people: ");
        double lawEnforcementPerCapita = scanner.nextDouble();
        System.out.print("Enter past crime rate (crimes per 100,000 people): ");
        double pastCrimeRate = scanner.nextDouble();

        // Predict and display crime likelihood
        String prediction = predictCrime(populationDensity, unemploymentRate, averageIncome, educationLevel, lawEnforcementPerCapita, pastCrimeRate);
        System.out.println("Prediction for crime likelihood: " + prediction);

        scanner.close();
    }

    public static String predictCrime(double populationDensity, double unemploymentRate, double averageIncome, double educationLevel, double lawEnforcementPerCapita, double pastCrimeRate) {
        // Calculate prediction score from factors
        double score = 0;
        score += (populationDensity > 2000) ? 2 : 0;
        score += (unemploymentRate > 10) ? 2 : 0;
        score += (averageIncome < 30000) ? 2 : 0;
        score += (educationLevel < 80) ? 1 : 0;
        score += (lawEnforcementPerCapita < 2.5) ? 2 : 0;
        score += (pastCrimeRate > 5000) ? 3 : 0;

        // Determine prediction 
        String prediction;
        if (score > 6) {
            prediction = "High likelihood of crime.";
        } else if (score > 3) {
            prediction = "Moderate likelihood of crime.";
        } else {
            prediction = "Low likelihood of crime.";
        }
        return prediction;
    }
}
