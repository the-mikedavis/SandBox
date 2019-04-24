#include <pcl/point_types.h>
#include <pcl/features/normal_3d.h>
#include <pcl/console/parse.h>
#include <pcl/io/pcd_io.h>
#include <pcl/visualization/pcl_visualizer.h>

std::string scene_filename_;

void show_help(char *filename) {
  std::cout << "usage: " << filename << " scene_filename.pcd" << std::endl << std::endl;
}

void parse_command_line(int argc, char *argv[]) {
  // Show help
  if (pcl::console::find_switch(argc, argv, "-h")) {
    show_help(argv[0]);
    exit(0);
  }

  // Model & scene filenames
  std::vector<int> filenames;
  filenames = pcl::console::parse_file_extension_argument(argc, argv, ".pcd");
  if (filenames.size() != 1) {
    std::cerr << "PCD file name missing from arguments.\n";
    show_help(argv[0]);
    exit(-1);
  }

  scene_filename_ = argv[filenames[0]];
}

int main(int argc, char **argv) {
  parse_command_line(argc, argv);

  pcl::PointCloud<pcl::PointXYZ>::Ptr cloud (new pcl::PointCloud<pcl::PointXYZ>);

  if (pcl::io::loadPCDFile(scene_filename_, *cloud) < 0) {
    perror("normal: loading the .pcd file");
    return -1;
  }

  // Create the normal estimation class, and pass the input dataset to it
  pcl::NormalEstimation<pcl::PointXYZ, pcl::Normal> normal_estimator;
  normal_estimator.setInputCloud (cloud);

  // Create an empty kdtree representation, and pass it to the normal estimation object.
  // Its content will be filled inside the object, based on the given input dataset (as no other search surface is given).
  pcl::search::KdTree<pcl::PointXYZ>::Ptr tree (new pcl::search::KdTree<pcl::PointXYZ> ());
  normal_estimator.setSearchMethod (tree);

  // Output datasets
  pcl::PointCloud<pcl::Normal>::Ptr cloud_normals (new pcl::PointCloud<pcl::Normal>);

  // Use all neighbors in a sphere of radius 3cm
  normal_estimator.setRadiusSearch (0.03);

  // Compute the features
  normal_estimator.compute (*cloud_normals);

  assert(cloud_normals->points.size() == cloud->points.size());

  {
    boost::shared_ptr<pcl::visualization::PCLVisualizer> viewer(
        new pcl::visualization::PCLVisualizer("3D Viewer"));
    // RGB 000 is black
    viewer->setBackgroundColor(0, 0, 0);
    viewer->addPointCloud<pcl::PointXYZ> (cloud, "scene cloud");
    viewer->addPointCloudNormals<pcl::PointXYZ, pcl::Normal> (cloud, cloud_normals, 10, 0.05, "normals");

    viewer->addCoordinateSystem(1.0);
    viewer->initCameraParameters();
    while (!viewer->wasStopped()) {
      viewer->spinOnce(100);
      boost::this_thread::sleep(boost::posix_time::microseconds(100000));
    }
  }

  return 0;
}
