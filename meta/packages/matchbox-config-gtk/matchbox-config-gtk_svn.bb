DESCRIPTION = "Matchbox GTK+ theme configuration application."
HOMEPAGE = "http://matchbox-project.org"
BUGTRACKER = "http://bugzilla.openedhand.com/"

LICENSE = "GPLv2+"

DEPENDS = "gconf gtk+"
RDEPENDS = "settings-daemon"

PV = "0.0+svnr${SRCREV}"

S = "${WORKDIR}/${PN}"

SRC_URI = "svn://svn.o-hand.com/repos/matchbox/trunk;module=${PN};proto=http \
        file://no-handed.patch;patch=1;pnum=0"

inherit autotools pkgconfig

