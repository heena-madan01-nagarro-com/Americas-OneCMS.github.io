/**
 * ======================================================================================================
 * AEM ClientLibraries Util
 * Helper functions to create client libraries
 * ======================================================================================================
 */

const fs = require('fs');
const fse = require('fs-extra');

const getFilesWithExtension = (folder, extension) => {
  return fse.readdirSync(folder).filter(file => file.endsWith(extension));
}

const replaceFileContent = (file, replace, replacement) => {
  fs.readFile(file, 'utf8', function (error, content) {
    if (error) {
      return console.error(error);
    }
    let replacedContent = content.replace(replace, replacement);
    fs.writeFileSync(file, replacedContent);
  });
}

class ClientLibrary {

  constructor(path, name, categories = [], dependencies = []) {
    this.clientLibFolder = `${path}/${name}`;
    this.config = {
      folder: `${this.clientLibFolder}`,
      jsFolder: `${this.clientLibFolder}/js`,
      cssFolder: `${this.clientLibFolder}/css`,
      definition: `${this.clientLibFolder}/.content.xml`,
      jsTxt: `${this.clientLibFolder}/js.txt`,
      cssTxt: `${this.clientLibFolder}/css.txt`,
      resourceFolder: `${this.clientLibFolder}/resources`
    };

    this.jsFiles = [];
    this.cssFiles = [];
    this.resourcesFolderPath = undefined;
    this.categories = categories;
    this.dependencies = dependencies;
  }

  clientLibraryDefinition() {
    return `<?xml version="1.0" encoding="UTF-8"?>
    <jcr:root xmlns:cq="http://www.day.com/jcr/cq/1.0" xmlns:jcr="http://www.jcp.org/jcr/1.0"
    jcr:primaryType="cq:ClientLibraryFolder"
    categories="[${this.categories || ''}]"
    dependencies="[${this.dependencies || ''}]"
    allowProxy="{Boolean}true" />`
  }

  create() {
    fse.mkdirSync(this.config.jsFolder, {recursive: true});
    fse.mkdirSync(this.config.cssFolder, {recursive: true});

    fse.writeFileSync(this.config.definition, this.clientLibraryDefinition());

    // Add JS files
    fse.writeFileSync(this.config.jsTxt, "#base=js\n");
    this.jsFiles.map(file => {
      let fileName = file.split("/").pop();
      fse.copySync(file, `${this.config.jsFolder}/${fileName}`);
      fse.appendFileSync(this.config.jsTxt, fileName + "\n");
    });

    // Add CSS files
    fse.writeFileSync(this.config.cssTxt, "#base=css\n");
    this.cssFiles.map(file => {
      let fileName = file.split("/").pop();
      fse.copySync(file, `${this.config.cssFolder}/${fileName}`);
      fse.appendFileSync(this.config.cssTxt, fileName + "\n");
    });

    // Copy resources folder
    if (this.resourcesFolderPath) {
      fse.copySync(this.resourcesFolderPath, this.config.resourceFolder);
    }
  }
}


module.exports = {
  ClientLibrary,
  getFilesWithExtension,
  replaceFileContent
}
