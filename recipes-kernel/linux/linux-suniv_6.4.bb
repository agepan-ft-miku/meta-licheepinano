SECTION = "kernel"
DESCRIPTION = "Nano Linux kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"
COMPATIBLE_MACHINE = "(suniv)"

inherit kernel

#require linux.inc
require recipes-kernel/linux/linux-yocto.inc

# Since we're not using git, this doesn't make a difference, but we need to fill
# in something or kernel-yocto.bbclass will fail.
PV = "6.4+git${SRCPV}"
KBRANCH = "master"

# Pull in the devicetree files into the rootfs
# RDEPENDS_${KERNEL_PACKAGE_NAME}-base += "kernel-devicetree"

KCONFIG_MODE ?= "alldefconfig"
KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"

S = "${WORKDIR}/git"
SRCREV_pn-${PN} = "6995e2de6891c724bfeb2db33d7b87775f913ad1"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}/licheepi-nano:"
SRC_URI += "\
		git://github.com/torvalds/linux.git;protocol=git;branch=${KBRANCH} \
		file://licheepi-nano/append_src \
        file://licheepi-nano/defconfig-usb/defconfig \
		file://licheepi-nano/defconfig-usb/add-composit-gadget-support.cfg \
		file://licheepi-nano/defconfig-usb/add-lcd-panel.cfg \
		file://licheepi-nano/defconfig-usb/change-console-font.cfg \
		file://licheepi-nano/add-support-st7789v-pannel.patch \
		file://licheepi-nano/defconfig-usb/add-bootup-logo.cfg \
        "

#		file://licheepi-nano/defconfig-usb/add-bootup-logo.cfg
#		file://licheepi-nano/disabled-fbcon.patch

do_patch_prepend() {
	cp -rf ${WORKDIR}/licheepi-nano/append_src/* ${S}
}
