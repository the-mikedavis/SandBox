cmake_minimum_required(VERSION 2.6 FATAL_ERROR)
project(pcl_sandbox)

set (CMAKE_CXX_STANDARD 11)

find_package(PCL 1.9 REQUIRED)

include_directories(${PCL_INCLUDE_DIRS})
link_directories(${PCL_LIBRARY_DIRS})
add_definitions(${PCL_DEFINITIONS})

add_executable(triangulation triangulation.cpp)
target_link_libraries(triangulation ${PCL_LIBRARIES})

add_executable(normal normal.cpp)
target_link_libraries(normal ${PCL_LIBRARIES})
