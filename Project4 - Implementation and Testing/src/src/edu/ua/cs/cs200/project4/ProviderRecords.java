package edu.ua.cs.cs200.project4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProviderRecords {

  private List<Provider> providers;

  public ProviderRecords() {
    providers = new ArrayList<>();
    // Load providers from the file on initialization
    loadProvidersFromFile();
  }

  public Provider getProvider(int providerID) {
    loadProvidersFromFile();
    for (Provider provider : providers) {
      if (provider.getProviderID() == providerID) {
        return provider;
      }
    }
    return null; // Provider not found
  }

  public void addProvider(Provider provider) {
    providers.add(provider);
    saveProvidersToFile(); // Save the updated list to the file
    loadProvidersFromFile();
  }

  public void removeProvider(Provider provider) {
    providers.remove(provider);
    saveProvidersToFile(); // Save the updated list to the file
    loadProvidersFromFile();
  }

  public List<Provider> getAllProviders() {
    return providers;
  }

  private void loadProvidersFromFile() {
    try (BufferedReader reader = new BufferedReader(new FileReader("src/providers.txt"))) {
      String line;
      while ((line = reader.readLine()) != null) {
        providers.add(new Provider(line));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void saveProvidersToFile() {
    try (PrintWriter writer = new PrintWriter(new FileWriter("src/providers.txt"))) {
      for (Provider provider : providers) {
        writer.println(provider.toString());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}