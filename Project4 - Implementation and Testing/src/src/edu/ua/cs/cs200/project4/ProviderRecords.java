package edu.ua.cs.cs200.project4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Manages the records of ChocAn service providers.
 * 
 * This class handles the addition, removal, retrieval, and listing of providers.
 * Providers are loaded from and saved to a file on initialization and modification.
 * The default file location for providers is "src/providers.txt".
 * 
 * @author dddierking
 */
public class ProviderRecords {

  private List<Provider> providers;

  /**
   * Initializes the ProviderRecords object and loads providers from the file.
   */
  public ProviderRecords() {
    providers = new ArrayList<>();
    loadProvidersFromFile();
  }

  /**
   * Retrieves a provider based on the provided providerID.
   * 
   * @param providerID The unique identifier of the provider.
   * @return The provider with the specified ID, or null if not found.
   */
  public Provider getProvider(int providerID) {
    for (Provider provider : providers) {
      if (provider.getProviderID() == providerID) {
        return provider;
      }
    }
    return null; // Provider not found
  }

  /**
   * Adds a new provider to the records.
   * 
   * @param provider The provider to be added.
   */
  public void addProvider(Provider provider) {
    providers.add(provider);
    saveProvidersToFile();
  }

  /**
   * Removes a provider from the records.
   * 
   * @param provider The provider to be removed.
   */
  public void removeProvider(Provider provider) {
    providers.remove(provider);
    saveProvidersToFile();
  }

  /**
   * Retrieves a list of all providers.
   * 
   * @return The list of all providers.
   */
  public List<Provider> getAllProviders() {
    return providers;
  }

  /**
   * Loads providers from the file.
   */
  private void loadProvidersFromFile() {
    try (BufferedReader reader = new BufferedReader(new FileReader("providers.txt"))) {
      String line;
      while ((line = reader.readLine()) != null) {
        providers.add(new Provider(line));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Saves providers to the file.
   */
  public void saveProvidersToFile() {
    try (PrintWriter writer = new PrintWriter(new FileWriter("providers.txt"))) {
      for (Provider provider : providers) {
        writer.println(provider.toString());
        System.out.println(provider.toString());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
