# CMAKE generated file: DO NOT EDIT!
# Generated by "MinGW Makefiles" Generator, CMake Version 3.16

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

SHELL = cmd.exe

# The CMake executable.
CMAKE_COMMAND = "C:\Program Files\JetBrains\CLion 2020.1.2\bin\cmake\win\bin\cmake.exe"

# The command to remove a file.
RM = "C:\Program Files\JetBrains\CLion 2020.1.2\bin\cmake\win\bin\cmake.exe" -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = C:\Users\20106\Documents\GitHub\Problem-Solving\C++

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = C:\Users\20106\Documents\GitHub\Problem-Solving\C++\cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/C__.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/C__.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/C__.dir/flags.make

CMakeFiles/C__.dir/brimore_2021/Brimore.cpp.obj: CMakeFiles/C__.dir/flags.make
CMakeFiles/C__.dir/brimore_2021/Brimore.cpp.obj: ../brimore_2021/Brimore.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=C:\Users\20106\Documents\GitHub\Problem-Solving\C++\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/C__.dir/brimore_2021/Brimore.cpp.obj"
	C:\MinGW\bin\g++.exe  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles\C__.dir\brimore_2021\Brimore.cpp.obj -c C:\Users\20106\Documents\GitHub\Problem-Solving\C++\brimore_2021\Brimore.cpp

CMakeFiles/C__.dir/brimore_2021/Brimore.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/C__.dir/brimore_2021/Brimore.cpp.i"
	C:\MinGW\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E C:\Users\20106\Documents\GitHub\Problem-Solving\C++\brimore_2021\Brimore.cpp > CMakeFiles\C__.dir\brimore_2021\Brimore.cpp.i

CMakeFiles/C__.dir/brimore_2021/Brimore.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/C__.dir/brimore_2021/Brimore.cpp.s"
	C:\MinGW\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S C:\Users\20106\Documents\GitHub\Problem-Solving\C++\brimore_2021\Brimore.cpp -o CMakeFiles\C__.dir\brimore_2021\Brimore.cpp.s

# Object files for target C__
C___OBJECTS = \
"CMakeFiles/C__.dir/brimore_2021/Brimore.cpp.obj"

# External object files for target C__
C___EXTERNAL_OBJECTS =

C__.exe: CMakeFiles/C__.dir/brimore_2021/Brimore.cpp.obj
C__.exe: CMakeFiles/C__.dir/build.make
C__.exe: CMakeFiles/C__.dir/linklibs.rsp
C__.exe: CMakeFiles/C__.dir/objects1.rsp
C__.exe: CMakeFiles/C__.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=C:\Users\20106\Documents\GitHub\Problem-Solving\C++\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable C__.exe"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles\C__.dir\link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/C__.dir/build: C__.exe

.PHONY : CMakeFiles/C__.dir/build

CMakeFiles/C__.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles\C__.dir\cmake_clean.cmake
.PHONY : CMakeFiles/C__.dir/clean

CMakeFiles/C__.dir/depend:
	$(CMAKE_COMMAND) -E cmake_depends "MinGW Makefiles" C:\Users\20106\Documents\GitHub\Problem-Solving\C++ C:\Users\20106\Documents\GitHub\Problem-Solving\C++ C:\Users\20106\Documents\GitHub\Problem-Solving\C++\cmake-build-debug C:\Users\20106\Documents\GitHub\Problem-Solving\C++\cmake-build-debug C:\Users\20106\Documents\GitHub\Problem-Solving\C++\cmake-build-debug\CMakeFiles\C__.dir\DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/C__.dir/depend

