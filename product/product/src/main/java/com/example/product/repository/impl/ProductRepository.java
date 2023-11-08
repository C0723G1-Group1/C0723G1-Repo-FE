package com.example.product.repository.impl;

import com.example.product.dto.ProductAdminDTO;
import com.example.product.dto.ProductDTO;
import com.example.product.model.*;
import com.example.product.repository.BaseRepository;
import com.example.product.repository.IProductRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProductRepository implements IProductRepository {


    private static final String SELECT_ALL_PRODUCT_RING_HOME =
            "select * from san_pham s join chat_lieu cl on cl.id = s.id_chat_lieu join loai_san_pham lsp on " +
                    "lsp.id = s.id_loai_san_pham where lsp.ten_loai like \"Nhẫn\" and s.trang_thai =1 order by s.gia limit 12;";
    private static final String SELECT_ALL_PRODUCT_RING =
            "select * from san_pham s join chat_lieu cl on cl.id = s.id_chat_lieu join loai_san_pham lsp on " +
                    "lsp.id = s.id_loai_san_pham where lsp.ten_loai like \"Nhẫn\" and s.trang_thai =1 order by s.gia;";
    private static final String SELECT_ALL_PRODUCT_NECKLACE_HOME = "select * from san_pham s join chat_lieu cl on cl.id = s.id_chat_lieu join loai_san_pham lsp" +
            " on lsp.id = s.id_loai_san_pham where lsp.ten_loai like \"Dây chuyền\" and s.trang_thai =1 order by s.gia limit 12;";
    private static final String SELECT_ALL_PRODUCT_NECKLACE = "select * from san_pham s join chat_lieu cl on cl.id = s.id_chat_lieu join loai_san_pham lsp" +
            " on lsp.id = s.id_loai_san_pham where lsp.ten_loai like \"Dây chuyền\" and s.trang_thai =1 order by s.gia;";
    private static final String SELECT_ALL_PRODUCT_OUTSTANDING = "select * from san_pham s join chat_lieu cl on cl.id = s.id_chat_lieu join loai_san_pham lsp on lsp.id = s.id_loai_san_pham where s.trang_thai =1 order by s.gia desc limit 12;";
    private static final String SELECT_ALL_PRODUCT_GOLD = "select * from san_pham s join chat_lieu cl on cl.id = s.id_chat_lieu join loai_san_pham lsp\n" +
            "           on lsp.id = s.id_loai_san_pham where cl.ten like \"Vàng\" and s.trang_thai =1 order by s.gia;";
    private static final String SELECT_ALL_PRODUCT_SILVER = "select * from san_pham s join chat_lieu cl on cl.id = s.id_chat_lieu join loai_san_pham lsp\n" +
            "           on lsp.id = s.id_loai_san_pham where cl.ten like \"Bạc\" and s.trang_thai =1 order by s.gia;";
    private static final String SELECT_ALL_PRODUCT_ADMIN
            = "select s.id as id_san_pham ,s.mo_ta as mo_ta_sp,s.*,lsp.*,cl.*,sz.* from san_pham s" +
            " join loai_san_pham lsp on lsp.id = s.id_loai_san_pham join chat_lieu cl on cl.id = s.id_chat_lieu join size sz on sz.id = s.id_size where s.trang_thai =1;";
    private static final String UPDATE_IMAGE = "update hinh_anh set link_path = ? where id = ? ";
    private static final String UUPDATE_PRODUCT = "update san_pham set ma_san_pham = ?, ten_san_pham = ?, id_loai_san_pham = ?, id_chat_lieu = ?, id_size =?, gia =?, so_luong =?,mo_ta = ? where id = ?;";
    private static final String SELECT_FROM_LOAI_SAN_PHAM = "select * from loai_san_pham;";
    private static final String SELECT_FROM_CHAT_LIEU = "select * from chat_lieu;";
    private static final String SELECT_FROM_SIZE = "select * from size;";
    private static final String SELECT_PRODUCT_BY_ID = "select s.id as id_san_pham ,s.mo_ta as mo_ta_sp,s.*,lsp.*,cl.*,sz.* from san_pham s join loai_san_pham lsp on lsp.id = s.id_loai_san_pham join chat_lieu cl on cl.id = s.id_chat_lieu join size sz on sz.id = s.id_size where s.ma_san_pham =? and s.trang_thai =1;";
    private static final String SELECT_ALL_MATERIAL = "select * from chat_lieu ;";
    private static final String SELECT_ALL_PRODUCT_TYPE = "select * from loai_san_pham;";
    private static final String SELECT_ALL_PRODUCT_SIZE = "select * from size;";
    private static final String SELECT_ID_BY_CODE = "select id from san_pham where ma_san_pham = ? and trang_thai =1;";
    private static final String SELECT_ID_BY_CODE_IMAGE = "select id from hinh_anh where link_path = ? and id_san_pham = ?;";
    private static final String INSERT_PRODUCT = "insert into san_pham(ma_san_pham,ten_san_pham,id_loai_san_pham,id_chat_lieu,id_size,gia,so_luong,mo_ta,trang_thai) value(?,?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String INSERT_IMAGE = "insert into hinh_anh(link_path,id_san_pham) value(?,?);";
    private static final String DELETE_PRODUCT = "update san_pham set trang_thai =0 where id = ?;";
    private static final String SELECT_ALL_ORDER_CART = "call get_all_cart(?);";
    private static final String RESERT_CART = "insert into gio_hang(id_tai_khoan,id_san_pham,so_luong) value(?,?,?);";
    private static final String SELECT_ID_BY_USER = "select id from tai_khoan where user_name like ?;";
    private static final String SELECT_ID_CART_BY_USER = "select gh.id as id_gio_hang,id_tai_khoan,id_san_pham,so_luong from gio_hang gh join tai_khoan tk on tk.id = gh.id_tai_khoan where user_name =?";
    private static final String DELETE_CART_BY_ID = "delete from gio_hang where id =?;";

    @Override
    public List<ProductDTO> findAllProductRingHome() {
        List<ProductDTO> productDTOList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT_RING_HOME);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String productName = resultSet.getString("ten_san_pham");
                String material = resultSet.getString("ten");
                int price = resultSet.getInt("gia");
                int id = resultSet.getInt("id");
                String productCode = resultSet.getString("ma_san_pham");
                PreparedStatement preparedStatement1 = connection.prepareStatement(
                        "select link_path from hinh_anh ha join san_pham sp on sp.id = ha.id_san_pham " +
                                "where sp.id =" + id + ";");
                ResultSet resultSet1 = preparedStatement1.executeQuery();
                List<String> imageList = new ArrayList<>();
                while (resultSet1.next()) {
                    String image = resultSet1.getString("link_path");
                    imageList.add(image);
                }
                productDTOList.add(new ProductDTO(productName, productCode, material, price, imageList));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productDTOList;
    }

    @Override
    public List<ProductDTO> findAllProductNecklaceHome() {
        List<ProductDTO> productDTOList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    SELECT_ALL_PRODUCT_NECKLACE_HOME);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String productName = resultSet.getString("ten_san_pham");
                String material = resultSet.getString("ten");
                int price = resultSet.getInt("gia");
                int id = resultSet.getInt("id");
                String productCode = resultSet.getString("ma_san_pham");
                PreparedStatement preparedStatement1 = connection.prepareStatement(
                        "select link_path from hinh_anh ha join san_pham sp on sp.id = ha.id_san_pham " +
                                "where sp.id =" + id + ";");
                ResultSet resultSet1 = preparedStatement1.executeQuery();
                List<String> imageList = new ArrayList<>();
                while (resultSet1.next()) {
                    String image = resultSet1.getString("link_path");
                    imageList.add(image);
                }
                productDTOList.add(new ProductDTO(productName, productCode, material, price, imageList));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productDTOList;
    }

    @Override
    public List<ProductDTO> findAllProductRing() {
        List<ProductDTO> productDTOList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT_RING);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String productName = resultSet.getString("ten_san_pham");
                String material = resultSet.getString("ten");
                int price = resultSet.getInt("gia");
                int id = resultSet.getInt("id");
                String productCode = resultSet.getString("ma_san_pham");
                PreparedStatement preparedStatement1 = connection.prepareStatement(
                        "select link_path from hinh_anh ha join san_pham sp on sp.id = ha.id_san_pham " +
                                "where sp.id =" + id + ";");
                ResultSet resultSet1 = preparedStatement1.executeQuery();
                List<String> imageList = new ArrayList<>();
                while (resultSet1.next()) {
                    String image = resultSet1.getString("link_path");
                    imageList.add(image);
                }
                productDTOList.add(new ProductDTO(productName, productCode, material, price, imageList));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productDTOList;
    }

    @Override
    public List<ProductDTO> findAllProductNecklace() {
        List<ProductDTO> productDTOList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    SELECT_ALL_PRODUCT_NECKLACE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String productName = resultSet.getString("ten_san_pham");
                String material = resultSet.getString("ten");
                int price = resultSet.getInt("gia");
                int id = resultSet.getInt("id");
                String productCode = resultSet.getString("ma_san_pham");
                PreparedStatement preparedStatement1 = connection.prepareStatement(
                        "select link_path from hinh_anh ha join san_pham sp on sp.id = ha.id_san_pham " +
                                "where sp.id =" + id + ";");
                ResultSet resultSet1 = preparedStatement1.executeQuery();
                List<String> imageList = new ArrayList<>();
                while (resultSet1.next()) {
                    String image = resultSet1.getString("link_path");
                    imageList.add(image);
                }
                productDTOList.add(new ProductDTO(productName, productCode, material, price, imageList));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productDTOList;
    }

    @Override
    public List<ProductDTO> findAllProductOutstandingHome() {
        List<ProductDTO> productDTOList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    SELECT_ALL_PRODUCT_OUTSTANDING);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String productName = resultSet.getString("ten_san_pham");
                String material = resultSet.getString("ten");
                int price = resultSet.getInt("gia");
                int id = resultSet.getInt("id");
                String productCode = resultSet.getString("ma_san_pham");
                PreparedStatement preparedStatement1 = connection.prepareStatement(
                        "select link_path from hinh_anh ha join san_pham sp on sp.id = ha.id_san_pham " +
                                "where sp.id =" + id + ";");
                ResultSet resultSet1 = preparedStatement1.executeQuery();
                List<String> imageList = new ArrayList<>();
                while (resultSet1.next()) {
                    String image = resultSet1.getString("link_path");
                    imageList.add(image);
                }
                productDTOList.add(new ProductDTO(productName, productCode, material, price, imageList));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productDTOList;
    }

    @Override
    public List<ProductDTO> findAllProductGold() {
        List<ProductDTO> productDTOList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    SELECT_ALL_PRODUCT_GOLD);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String productName = resultSet.getString("ten_san_pham");
                String material = resultSet.getString("ten");
                int price = resultSet.getInt("gia");
                int id = resultSet.getInt("id");
                String productCode = resultSet.getString("ma_san_pham");
                PreparedStatement preparedStatement1 = connection.prepareStatement(
                        "select link_path from hinh_anh ha join san_pham sp on sp.id = ha.id_san_pham " +
                                "where sp.id =" + id + ";");
                ResultSet resultSet1 = preparedStatement1.executeQuery();
                List<String> imageList = new ArrayList<>();
                while (resultSet1.next()) {
                    String image = resultSet1.getString("link_path");
                    imageList.add(image);
                }
                productDTOList.add(new ProductDTO(productName, productCode, material, price, imageList));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productDTOList;
    }

    @Override
    public List<ProductDTO> findAllProductSilver() {
        List<ProductDTO> productDTOList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    SELECT_ALL_PRODUCT_SILVER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String productName = resultSet.getString("ten_san_pham");
                String material = resultSet.getString("ten");
                int price = resultSet.getInt("gia");
                int id = resultSet.getInt("id");
                String productCode = resultSet.getString("ma_san_pham");
                PreparedStatement preparedStatement1 = connection.prepareStatement(
                        "select link_path from hinh_anh ha join san_pham sp on sp.id = ha.id_san_pham " +
                                "where sp.id =" + id + ";");
                ResultSet resultSet1 = preparedStatement1.executeQuery();
                List<String> imageList = new ArrayList<>();
                while (resultSet1.next()) {
                    String image = resultSet1.getString("link_path");
                    imageList.add(image);
                }
                productDTOList.add(new ProductDTO(productName, productCode, material, price, imageList));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productDTOList;
    }

    @Override
    public List<ProductAdminDTO> findAllProductAdmin() {
        List<ProductAdminDTO> productAdminDTOList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT_ADMIN);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String productCode = resultSet.getString("ma_san_pham");
                String productName = resultSet.getString("ten_san_pham");
                String material = resultSet.getString("ten");
                String productType = resultSet.getString("ten_loai");
                String size = resultSet.getString("ten_size");
                int quantity = resultSet.getInt("so_luong");
                int price = resultSet.getInt("gia");
                int id = resultSet.getInt("id_san_pham");
                PreparedStatement preparedStatement1 = connection.prepareStatement(
                        "select link_path from hinh_anh ha join san_pham sp on sp.id = ha.id_san_pham " +
                                "where sp.id =" + id + ";");
                ResultSet resultSet1 = preparedStatement1.executeQuery();
                List<String> imageList = new ArrayList<>();
                while (resultSet1.next()) {
                    String image = resultSet1.getString("link_path");
                    imageList.add(image);
                }
                String describe = resultSet.getString("mo_ta_sp");
                productAdminDTOList.add(new ProductAdminDTO(id, productCode, productName, material, productType, size, quantity, price, imageList, describe));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productAdminDTOList;
    }

    @Override
    public boolean updateProduct(ProductAdminDTO productAdminDTO) {
        boolean rowUpdated = false;
        Connection connection = BaseRepository.getConnectDB();
        try {
            connection.setAutoCommit(false);
            int rowEffect = 0;
            int count = 0;
            //update bảng hinh ảnh
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_IMAGE);
            for (String link_path : productAdminDTO.getImage()) {
                preparedStatement.setString(1, link_path);
                preparedStatement.setInt(2, getIdImage(link_path, productAdminDTO.getId()));
                rowEffect += preparedStatement.executeUpdate();
                count++;
            }
            //update bảng sản phẩm
            PreparedStatement preparedStatement1 = connection.prepareStatement(
                    UUPDATE_PRODUCT);
            preparedStatement1.setString(1, productAdminDTO.getProductCode());
            preparedStatement1.setString(2, productAdminDTO.getProductName());
            List<ProductType> productTypeList = new ArrayList<>();
            PreparedStatement preparedStatement2 = connection.prepareStatement(SELECT_FROM_LOAI_SAN_PHAM);
            ResultSet resultSet = preparedStatement2.executeQuery();
            while (resultSet.next()) {
                int id = Integer.parseInt(resultSet.getString("id"));
                String productTypeCode = resultSet.getString("ma_loai_sp");
                String productTypeName = resultSet.getString("ten_loai");
                String describe = resultSet.getString("mo_ta");
                productTypeList.add(new ProductType(id, productTypeCode, productTypeName, describe));
            }
            for (ProductType productType : productTypeList) {
                if (productAdminDTO.getProductType().equals(productType.getProductTypeName())) {
                    preparedStatement1.setInt(3, productType.getId());
                    break;
                }
            }
            List<Material> materialList = new ArrayList<>();
            PreparedStatement preparedStatement3 = connection.prepareStatement(SELECT_FROM_CHAT_LIEU);
            ResultSet resultSet3 = preparedStatement3.executeQuery();
            while (resultSet3.next()) {
                int id = Integer.parseInt(resultSet3.getString("id"));
                String materialCode = resultSet3.getString("ma_chat_lieu");
                String materialName = resultSet3.getString("ten");
                String describe = resultSet3.getString("mo_ta");
                materialList.add(new Material(id, materialCode, materialName, describe));
            }
            for (Material material : materialList) {
                if (productAdminDTO.getMaterial().equals(material.getMaterialName())) {
                    preparedStatement1.setInt(4, material.getId());
                    break;
                }
            }
            List<ProductSize> productSizeList = new ArrayList<>();
            PreparedStatement preparedStatement4 = connection.prepareStatement(SELECT_FROM_SIZE);
            ResultSet resultSet4 = preparedStatement4.executeQuery();
            while (resultSet4.next()) {
                int id = Integer.parseInt(resultSet4.getString("id"));
                String sizeCode = resultSet4.getString("ma_size");
                String sizeName = resultSet4.getString("ten_size");
                String describe = resultSet4.getString("mo_ta");
                productSizeList.add(new ProductSize(id, sizeCode, sizeName, describe));
            }
            for (ProductSize productSize : productSizeList) {
                if (productAdminDTO.getSize().equals(productSize.getSizeName())) {
                    preparedStatement1.setInt(5, productSize.getId());
                    break;
                }
            }
            preparedStatement1.setInt(6, productAdminDTO.getPrice());
            preparedStatement1.setInt(7, productAdminDTO.getQuantity());
            preparedStatement1.setString(8, productAdminDTO.getDescribe());
            preparedStatement1.setInt(9, productAdminDTO.getId());
            rowEffect += preparedStatement1.executeUpdate();
            if (rowEffect == count + 1) {
                connection.commit();
                rowUpdated = true;
            }

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return rowUpdated;
    }

    @Override
    public ProductAdminDTO selectProductAdminDTO(String id) {
        ProductAdminDTO productAdminDTO = null;
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int productId = resultSet.getInt("id_san_pham");
                String productName = resultSet.getString("ten_san_pham");
                String material = resultSet.getString("ten");
                String productType = resultSet.getString("ten_loai");
                String size = resultSet.getString("ten_size");
                int quantity = resultSet.getInt("so_luong");
                int price = resultSet.getInt("gia");
                PreparedStatement preparedStatement1 = connection.prepareStatement("select link_path from hinh_anh ha join san_pham sp on sp.id = ha.id_san_pham where sp.ma_san_pham = ?;");
                preparedStatement1.setString(1, id);
                ResultSet resultSet1 = preparedStatement1.executeQuery();
                List<String> imageList = new ArrayList<>();
                while (resultSet1.next()) {
                    String image = resultSet1.getString("link_path");
                    imageList.add(image);
                }
                String describe = resultSet.getString("mo_ta_sp");
                productAdminDTO = new ProductAdminDTO(productId, id, productName, material, productType, size, quantity, price, imageList, describe);
                ;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productAdminDTO;
    }

    @Override
    public List<Material> displayAllMaterial() {
        List<Material> materialList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MATERIAL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String materialCode = resultSet.getString("ma_chat_lieu");
                String materialName = resultSet.getString("ten");
                String describe = resultSet.getString("mo_ta");
                materialList.add(new Material(id, materialCode, materialName, describe));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return materialList;

    }

    @Override
    public List<ProductType> displayAllProductType() {
        List<ProductType> productTypeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT_TYPE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String productTypeCode = resultSet.getString("ma_loai_sp");
                String productTypeName = resultSet.getString("ten_loai");
                String describe = resultSet.getString("mo_ta");
                productTypeList.add(new ProductType(id, productTypeCode, productTypeName, describe));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productTypeList;
    }

    @Override
    public List<ProductSize> displayAllProductSize() {
        List<ProductSize> productSizeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT_SIZE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String sizeCode = resultSet.getString("ma_size");
                String sizeName = resultSet.getString("ten_size");
                String describe = resultSet.getString("mo_ta");
                productSizeList.add(new ProductSize(id, sizeCode, sizeName, describe));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productSizeList;
    }

    @Override
    public int getIdByCode(String code) {
        Connection connection = BaseRepository.getConnectDB();
        int id;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ID_BY_CODE);
            preparedStatement.setString(1, code);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                id = resultSet.getInt("id");

            } else {
                id = -1;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return id;
    }

    @Override
    public int getIdImage(String linkPath, int id) {
        Connection connection = BaseRepository.getConnectDB();
        int idImage;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ID_BY_CODE_IMAGE);
            preparedStatement.setString(1, linkPath);
            preparedStatement.setInt(2, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                idImage = resultSet.getInt("id");

            } else {
                idImage = -1;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return idImage;
    }

    @Override
    public void insertProductAdminDTO(ProductAdminDTO productAdminDTO) {
        Connection connection = BaseRepository.getConnectDB();
        // create bảng san pham
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT);
            preparedStatement.setString(1, productAdminDTO.getProductCode());
            preparedStatement.setString(2, productAdminDTO.getProductName());
            List<ProductType> productTypeList = new ArrayList<>();
            PreparedStatement preparedStatement2 = connection.prepareStatement(SELECT_FROM_LOAI_SAN_PHAM);
            ResultSet resultSet = preparedStatement2.executeQuery();
            while (resultSet.next()) {
                int id = Integer.parseInt(resultSet.getString("id"));
                String productTypeCode = resultSet.getString("ma_loai_sp");
                String productTypeName = resultSet.getString("ten_loai");
                String describe = resultSet.getString("mo_ta");
                productTypeList.add(new ProductType(id, productTypeCode, productTypeName, describe));
            }
            for (ProductType productType : productTypeList) {
                if (productAdminDTO.getProductType().equals(productType.getProductTypeName())) {
                    preparedStatement.setInt(3, productType.getId());
                    break;
                }
            }
            List<Material> materialList = new ArrayList<>();
            PreparedStatement preparedStatement3 = connection.prepareStatement(SELECT_FROM_CHAT_LIEU);
            ResultSet resultSet3 = preparedStatement3.executeQuery();
            while (resultSet3.next()) {
                int id = Integer.parseInt(resultSet3.getString("id"));
                String materialCode = resultSet3.getString("ma_chat_lieu");
                String materialName = resultSet3.getString("ten");
                String describe = resultSet3.getString("mo_ta");
                materialList.add(new Material(id, materialCode, materialName, describe));
            }
            for (Material material : materialList) {
                if (productAdminDTO.getMaterial().equals(material.getMaterialName())) {
                    preparedStatement.setInt(4, material.getId());
                    break;
                }
            }
            List<ProductSize> productSizeList = new ArrayList<>();
            PreparedStatement preparedStatement4 = connection.prepareStatement(SELECT_FROM_SIZE);
            ResultSet resultSet4 = preparedStatement4.executeQuery();
            while (resultSet4.next()) {
                int id = Integer.parseInt(resultSet4.getString("id"));
                String sizeCode = resultSet4.getString("ma_size");
                String sizeName = resultSet4.getString("ten_size");
                String describe = resultSet4.getString("mo_ta");
                productSizeList.add(new ProductSize(id, sizeCode, sizeName, describe));
            }
            for (ProductSize productSize : productSizeList) {
                if (productAdminDTO.getSize().equals(productSize.getSizeName())) {
                    preparedStatement.setInt(5, productSize.getId());
                    break;
                }
            }
            preparedStatement.setInt(6, productAdminDTO.getPrice());
            preparedStatement.setInt(7, productAdminDTO.getQuantity());
            preparedStatement.setString(8, productAdminDTO.getDescribe());
            preparedStatement.setInt(9, 1);
            preparedStatement.executeUpdate();
            //create hinh_anh
            PreparedStatement preparedStatement5 = connection.prepareStatement(INSERT_IMAGE);
            for (String link_path : productAdminDTO.getImage()) {
                preparedStatement5.setString(1, link_path);
                preparedStatement5.setInt(2, getIdByCode(productAdminDTO.getProductCode()));
                preparedStatement5.executeUpdate();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public boolean deleteProduct(String productCode) {
        boolean rowDelete;
        Connection connection = BaseRepository.getConnectDB();
        int id = getIdByCode(productCode);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT);
            preparedStatement.setInt(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowDelete;
    }

    @Override
    public void insertOrderCard(OrderCart orderCart) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(RESERT_CART);
            preparedStatement.setInt(1, orderCart.getIdAccount());
            preparedStatement.setInt(2, orderCart.getIdProduct());
            preparedStatement.setInt(3, orderCart.getQuantity());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<OrderCartDTO> displayAllOrderCard(String user) {
        List<OrderCartDTO> orderCartDTOList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ORDER_CART);
            preparedStatement.setString(1, user);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String productName = resultSet.getString("ten_san_pham");
                String productCode = resultSet.getString("ma_san_pham");
                String linkPath = resultSet.getString("link_path");
                int quantity = resultSet.getInt("so_luong");
                int provisional = resultSet.getInt("tam_tinh");
                orderCartDTOList.add(new OrderCartDTO(productName, productCode, linkPath, quantity, provisional));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orderCartDTOList;
    }

    @Override
    public int getIdAccountByUser(String user) {
        Connection connection = BaseRepository.getConnectDB();
        int id;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ID_BY_USER);
            preparedStatement.setString(1, user);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                id = resultSet.getInt("id");
            } else {
                id = -1;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return id;
    }

    @Override
    public boolean deleteOrderCart(int id) {
        boolean rowDelete;
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CART_BY_ID);
            preparedStatement.setInt(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowDelete;
    }

    @Override
    public List<OrderCart> displayAllOrderCardByUser(String user) {
        List<OrderCart> orderCartList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ID_CART_BY_USER);
            preparedStatement.setString(1, user);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_gio_hang");
                int idAccount = resultSet.getInt("id_tai_khoan");
                int idProduct = resultSet.getInt("id_san_pham");
                int quantity = resultSet.getInt("so_luong");
                orderCartList.add(new OrderCart(id, idAccount, idProduct, quantity));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orderCartList;
    }


}


