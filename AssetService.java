package com.example.demo.service;

import com.example.demo.entity.Asset;
import com.example.demo.repository.AssetRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AssetService {

    private final AssetRepository assetRepository;

    public AssetService(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    public Asset addAsset(Asset asset) {
        return assetRepository.save(asset);
    }

    public List<Asset> getAllAssets() {
        return assetRepository.findAll();
    }

    public Asset getAssetById(Long id) {
        return assetRepository.findById(id).orElse(null);
    }

    public List<Asset> getAssetsByCategory(String category) {
        return assetRepository.findByCategory(category);
    }

    public Asset updateAsset(Long id, Asset assetDetails) {
        Asset asset = getAssetById(id);

        if (asset == null) {
            return null;
        }

        asset.setAssetName(assetDetails.getAssetName());
        asset.setCategory(assetDetails.getCategory());
        asset.setPurchaseValue(assetDetails.getPurchaseValue());
        asset.setAssignedTo(assetDetails.getAssignedTo());

        return assetRepository.save(asset);
    }

    public String deleteAsset(Long id) {
        if (getAssetById(id) != null) {
            assetRepository.deleteById(id);
            return "Asset with ID " + id + " has been successfully deleted.";
        }

        return "Asset with ID " + id + " not found.";
    }
}
