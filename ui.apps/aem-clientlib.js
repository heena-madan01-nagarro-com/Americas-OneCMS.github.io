/**
 * ======================================================================================================
 * AEM ClientLibraries Automation Tool
 * Creates AEM ClientLibraries from selected NPM dependencies
 * ======================================================================================================
 */

const fse = require('fs-extra');

const {ClientLibrary, getFilesWithExtension, replaceFileContent} = require('./aem-clientlibs-utils.js');

const NODE_MODULES_FOLDER = "node_modules";
const CLIENTLIBS_ROOT_FOLDER = "./src/main/content/jcr_root/apps/onecms/clientlibs";

fse.readdirSync(NODE_MODULES_FOLDER).map(module => {
	let clientlibName = module;
	let modulePath = `./${NODE_MODULES_FOLDER}/${module}`;
	let clientLib = new ClientLibrary(`${CLIENTLIBS_ROOT_FOLDER}/components`, clientlibName);
	clientLib.categories = [`assa-abloy-onecms.${clientlibName}`];
	clientLib.dependencies = '';
	getFilesWithExtension(modulePath,".js").map(file => clientLib.jsFiles.push(`${modulePath}/${file}`));
	getFilesWithExtension(modulePath,".css").map(file => clientLib.cssFiles.push(`${modulePath}/${file}`));
	clientLib.create();
});